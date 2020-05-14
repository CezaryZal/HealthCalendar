package com.CezaryZal.api.training.manager;

import com.CezaryZal.api.ApiEntityDto;
import com.CezaryZal.api.training.model.TrainingDto;
import com.CezaryZal.api.training.model.TrainingsSummary;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class TrainingsSummaryCreatorTest {

    @Test
    void shouldReturnTrainingSummeryFromCreateTrainingSummeryMethod(){
        TrainingsSummaryCreator trainingsSummaryCreator = new TrainingsSummaryCreator();

        TrainingDto firstExpectedTrainingDto = TrainingDto.builder()
                .id(1L)
                .dateTimeOfExecution(LocalDateTime.of(2020, 11, 11, 11, 11))
                .description("description")
                .elapsedTime(LocalTime.of(1,10))
                .burnKcal(10)
                .dayId(1L)
                .buildDto();
        TrainingDto secondExpectedTrainingDto = TrainingDto.builder()
                .id(2L)
                .dateTimeOfExecution(LocalDateTime.of(2020, 12, 12, 12, 12))
                .description("description")
                .elapsedTime(LocalTime.of(2,20))
                .burnKcal(20)
                .dayId(2L)
                .buildDto();

        List<ApiEntityDto> listTrainingDto = Arrays.asList(firstExpectedTrainingDto, secondExpectedTrainingDto);

        TrainingsSummary actualTrainingsSummary = trainingsSummaryCreator.createTrainingsSummary(listTrainingDto);
        TrainingsSummary expectedTrainingSummary =
                new TrainingsSummary(listTrainingDto, 30, LocalTime.of(3,30));
        TrainingsSummary notExpectedTrainingsSummary =
                new TrainingsSummary(listTrainingDto, 5, LocalTime.of(1,11));

        assertThat(actualTrainingsSummary).isEqualTo(expectedTrainingSummary);
        assertThat(actualTrainingsSummary).isNotEqualTo(notExpectedTrainingsSummary);
    }

}