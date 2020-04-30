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

    @Test
    void shouldThrowExceptionWhenSendingTooLongStringToDescription() {
        Set<ConstraintViolation<TrainingDto>> constraintViolations =
                validator.validateValue(
                        TrainingDto.class,
                        "description",
                        "a sample description of meal, that will be too long, " +
                                "which should throw an exception with the error message");

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("The 'description' should be between 3 and 100 characters")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSendingTooShortStringToDescription(){
        Set<ConstraintViolation<TrainingDto>> constraintViolations =
                validator.validateValue(TrainingDto.class, "description", "tmp");

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("The 'description' should be between 3 and 100 characters")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSendingNullToDescription(){
        Set<ConstraintViolation<TrainingDto>> constraintViolations =
                validator.validateValue(TrainingDto.class, "description", null);

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("The 'description' should not be blank")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSendingBlankStringToDescription(){
        Set<ConstraintViolation<TrainingDto>> constraintViolations =
                validator.validateValue(TrainingDto.class, "description", "       ");

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("The 'description' should not be blank")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSendingNullToElapsedTime(){
        Set<ConstraintViolation<TrainingDto>> constraintViolations =
                validator.validateValue(TrainingDto.class, "elapsedTime", null);

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("The 'elapsedTime' should not be null")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSendingTimeEqualZeroToElapsedTime(){
        Set<ConstraintViolation<TrainingDto>> constraintViolations =
                validator.validateValue(TrainingDto.class, "elapsedTime", LocalTime.of(0,0));

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("The training time should be between 0:01 and 3:00 hours")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSendingTimeOver3HourToElapsedTime(){
        Set<ConstraintViolation<TrainingDto>> constraintViolations =
                validator.validateValue(TrainingDto.class, "elapsedTime", LocalTime.of(3,1));

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("The training time should be between 0:01 and 3:00 hours")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSendingTooSmallValueOfKcal() {
        Set<ConstraintViolation<TrainingDto>> constraintViolations =
                validator.validateValue(TrainingDto.class, "burnKcal", 20);

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("The value of burnKcal entered is too small, min is 30")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSendingTooBigValueOfKcal() {
        Set<ConstraintViolation<TrainingDto>> constraintViolations =
                validator.validateValue(TrainingDto.class, "burnKcal", 6001);

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("The value of burnKcal entered is too big, max is 6000")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSendingNegativeNumberToKcal() {
        Set<ConstraintViolation<TrainingDto>> constraintViolations =
                validator.validateValue(TrainingDto.class, "burnKcal", -8);

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("The value of burnKcal entered is too small, min is 30")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSendingNullToKcal() {
        Set<ConstraintViolation<TrainingDto>> constraintViolations =
                validator.validateValue(TrainingDto.class, "burnKcal", null);

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("The 'burnKcal' should not be null")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSendingNegativeValueToDayId(){
        Set<ConstraintViolation<TrainingDto>> constraintViolations =
                validator.validateValue(TrainingDto.class, "dayId", -1L);

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("must be greater than 0")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSendingNullToDayId(){
        Set<ConstraintViolation<TrainingDto>> constraintViolations =
                validator.validateValue(TrainingDto.class, "dayId", null);

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("The 'dayId' should not be null")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSendingZeroNumberToDayId(){
        Set<ConstraintViolation<TrainingDto>> constraintViolations =
                validator.validateValue(TrainingDto.class, "dayId", 0L);

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("must be greater than 0")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }
}