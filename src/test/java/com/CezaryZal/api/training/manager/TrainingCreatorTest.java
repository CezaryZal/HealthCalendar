package com.CezaryZal.api.training.manager;

import com.CezaryZal.api.training.model.TrainingDto;
import com.CezaryZal.api.training.model.entity.Training;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.*;

class TrainingCreatorTest {

    private TrainingCreator trainingCreator;
    private Training secondExpectedTraining;

    @BeforeEach
    void setUp() {
        trainingCreator = new TrainingCreator();
        secondExpectedTraining = Training.builder()
                .dateTimeOfExecution(LocalDateTime.of(2020, 12, 12, 12, 12))
                .description("description")
                .elapsedTime(LocalTime.of(2,20))
                .burnKcal(20)
                .dayId(2L)
                .build();
    }

    @Test
    void shouldReturnProperlyTrainingFromCreateTrainingToUpdateByDtoAndTrainingIdMethod(){
        TrainingDto firstActualTrainingDto = TrainingDto.builder()
                .id(1L)
                .dateTimeOfExecution(LocalDateTime.of(2020, 11, 11, 11, 11))
                .description("description")
                .elapsedTime(LocalTime.of(1,10))
                .burnKcal(10)
                .dayId(1L)
                .buildDto();
        Training firstExpectedTraining = Training.builder()
                .id(1L)
                .dateTimeOfExecution(LocalDateTime.of(2020, 11, 11, 11, 11))
                .description("description")
                .elapsedTime(LocalTime.of(1,10))
                .burnKcal(10)
                .dayId(1L)
                .build();

        Training firstActualTraining =
                (Training)trainingCreator.createApiEntityToUpdateByDtoAndApiEntityId(firstActualTrainingDto);
        assertThat(firstActualTraining).isEqualTo(firstExpectedTraining);
        assertThat(firstExpectedTraining).isNotEqualTo(secondExpectedTraining);
    }

    @Test
    void shouldReturnProperlyTrainingFromCreateTrainingByDtoAndTrainingId(){
        TrainingDto firstActualTrainingDto = TrainingDto.builder()
                .dateTimeOfExecution(LocalDateTime.of(2020, 11, 11, 11, 11))
                .description("description")
                .elapsedTime(LocalTime.of(1,10))
                .burnKcal(10)
                .dayId(1L)
                .buildDto();

        Training firstExpectedTraining = Training.builder()
                .dateTimeOfExecution(LocalDateTime.of(2020, 11, 11, 11, 11))
                .description("description")
                .elapsedTime(LocalTime.of(1,10))
                .burnKcal(10)
                .dayId(1L)
                .build();

        Training firstActualTraining =
                (Training)trainingCreator.createApiEntityByDtoAndApiEntityId(firstActualTrainingDto);
        assertThat(firstActualTraining).isEqualTo(firstExpectedTraining);
        assertThat(firstExpectedTraining).isNotEqualTo(secondExpectedTraining);
    }
}