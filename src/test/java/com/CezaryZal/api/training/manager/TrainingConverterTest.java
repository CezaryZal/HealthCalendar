package com.CezaryZal.api.training.manager;

import com.CezaryZal.api.ApiEntity;
import com.CezaryZal.api.ApiEntityDto;
import com.CezaryZal.api.training.model.TrainingDto;
import com.CezaryZal.api.training.model.entity.Training;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class TrainingConverterTest {

    private TrainingConverter trainingConverter;
    private TrainingDto firstExpectedTrainingDto;
    private TrainingDto secondExpectedTrainingDto;
    private Training firstActualTraining;

    @BeforeEach
    void setUp() {
        trainingConverter = new TrainingConverter();
        firstExpectedTrainingDto = TrainingDto.builder()
                .id(1L)
                .dateTimeOfExecution(LocalDateTime.of(2020, 11, 11, 11, 11))
                .description("description")
                .elapsedTime(LocalTime.of(1,10))
                .burnKcal(10)
                .dayId(1L)
                .buildDto();
        secondExpectedTrainingDto = TrainingDto.builder()
                .id(2L)
                .dateTimeOfExecution(LocalDateTime.of(2020, 12, 12, 12, 12))
                .description("description")
                .elapsedTime(LocalTime.of(2,20))
                .burnKcal(20)
                .dayId(2L)
                .buildDto();
        firstActualTraining = Training.builder()
                .id(1L)
                .dateTimeOfExecution(LocalDateTime.of(2020, 11, 11, 11, 11))
                .description("description")
                .elapsedTime(LocalTime.of(1,10))
                .burnKcal(10)
                .dayId(1L)
                .build();
    }

    @Test
    void shouldReturnProperlyCreatedTrainingDto(){
        TrainingDto actualTrainingDto =
                (TrainingDto) trainingConverter.mappingApiEntityToDto(firstActualTraining);
        assertThat(actualTrainingDto).isEqualTo(firstExpectedTrainingDto);
        assertThat(firstExpectedTrainingDto).isNotEqualTo(secondExpectedTrainingDto);
    }

    @Test
    void shouldReturnProperlyCreatedListTrainingDto(){
        Training secondActualTraining = Training.builder()
                .id(2L)
                .dateTimeOfExecution(LocalDateTime.of(2020, 12, 12, 12, 12))
                .description("description")
                .elapsedTime(LocalTime.of(2,20))
                .burnKcal(20)
                .dayId(2L)
                .build();

        List<TrainingDto> expectedListTrainingDto =
                Arrays.asList(firstExpectedTrainingDto, secondExpectedTrainingDto);
        List<ApiEntity> actualListTraining = Arrays.asList(firstActualTraining, secondActualTraining);

        List<ApiEntityDto> actualListTrainingDto =
                trainingConverter.mappingListApiEntityToListDto(actualListTraining);

        assertThat(actualListTrainingDto).isEqualTo(expectedListTrainingDto);
    }
}