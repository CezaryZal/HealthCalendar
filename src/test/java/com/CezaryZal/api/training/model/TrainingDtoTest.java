package com.CezaryZal.api.training.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class TrainingDtoTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void shouldCompareToSimilarTrainingDto(){
        TrainingDto expectedTraining = TrainingDto.builder()
                .id(1L)
                .dateTimeOfExecution(LocalDateTime.of(2018, 12, 20, 12, 10, 25))
                .description("Bieganie")
                .elapsedTime(LocalTime.of(1, 15))
                .burnKcal(300)
                .dayId(2L)
                .buildDto();

        TrainingDto newTraining = TrainingDto.builder()
                .id(1L)
                .dateTimeOfExecution(LocalDateTime.of(2018, 12, 20, 12, 10, 25))
                .description("Bieganie")
                .elapsedTime(LocalTime.of(1, 15))
                .burnKcal(300)
                .dayId(2L)
                .buildDto();

        Assertions.assertThat(expectedTraining).isEqualTo(newTraining);
    }

    @Test
    void shouldThrowExceptionWhenSendingNegativeValueToId(){
        Set<ConstraintViolation<TrainingDto>> constraintViolations =
                validator.validateValue(TrainingDto.class, "id", -1L);

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("must be greater than 0")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSendingZeroNumberToId(){
        Set<ConstraintViolation<TrainingDto>> constraintViolations =
                validator.validateValue(TrainingDto.class, "id", 0L);

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("must be greater than 0")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSendingNullToDataTimeOfEat(){
        Set<ConstraintViolation<TrainingDto>> constraintViolations =
                validator.validateValue(TrainingDto.class, "dateTimeOfExecution", null);

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("The 'dateTimeOfExecution' should not be null")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSendingDateFromPastToDateTimeOfEat(){
        Set<ConstraintViolation<TrainingDto>> constraintViolations =
                validator.validateValue(TrainingDto.class,
                        "dateTimeOfExecution",
                        LocalDateTime.now().minusHours(24).minusMinutes(1));

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("The date time should be current")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSendingDateFromFutureToDateTimeOfEat(){
        Set<ConstraintViolation<TrainingDto>> constraintViolations =
                validator.validateValue(TrainingDto.class,
                        "dateTimeOfExecution",
                        LocalDateTime.now().plusHours(24).plusMinutes(1));

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("The date time should be current")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

}