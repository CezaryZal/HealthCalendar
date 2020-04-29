package com.CezaryZal.api.training.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;

class TrainingDtoTest {

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

}