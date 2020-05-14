package com.CezaryZal.api.training.manager;

import com.CezaryZal.api.ApiEntityDto;
import com.CezaryZal.api.day.repo.DayRepository;
import com.CezaryZal.api.report.shortened.manager.ShortReportUpdater;
import com.CezaryZal.api.training.manager.validation.MaxNumberOfTrainingsPerDayValidator;
import com.CezaryZal.api.training.manager.validation.TrainingValidator;
import com.CezaryZal.api.training.model.TrainingDto;
import com.CezaryZal.api.training.model.TrainingsSummary;
import com.CezaryZal.api.training.model.entity.Training;
import com.CezaryZal.api.training.repo.TrainingRepository;
import com.CezaryZal.validation.validator.IdsByDateOverlappingDataValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class TrainingServiceTest {

    @Mock
    private TrainingRepository trainingRepository;
    @Mock
    private ShortReportUpdater shortReportUpdater;
    @Mock
    private DayRepository dayRepository;

    @Spy
    private TrainingConverter trainingConverter;
    @Spy
    private TrainingsSummaryCreator trainingsSummaryCreator;
    @Spy
    private TrainingCreator trainingCreator;

    @InjectMocks
    private MaxNumberOfTrainingsPerDayValidator maxNumberOfTrainingsPerDayValidator;
    @InjectMocks
    private IdsByDateOverlappingDataValidator idsByDateOverlappingDataValidator;
    @InjectMocks
    private TrainingValidator trainingValidator;
    @InjectMocks
    private TrainingService trainingService;

    private Training firstSampleTraining;
    private TrainingDto firstSampleTrainingDto;
    private Training secondSampleTraining;
    private TrainingDto secondSampleTrainingDto;

    private List<Training> firstTrainingList;
    private List<TrainingDto> firstTrainingDtoList;

    @BeforeEach
    void setUp() {
        firstSampleTraining = Training.builder()
                .id(1L)
                .dateTimeOfExecution(LocalDateTime.of(2020, 11, 11, 11, 11))
                .description("description")
                .elapsedTime(LocalTime.of(1,10))
                .burnKcal(10)
                .dayId(1L)
                .build();
        firstSampleTrainingDto = TrainingDto.builder()
                .id(1L)
                .dateTimeOfExecution(LocalDateTime.of(2020, 11, 11, 11, 11))
                .description("description")
                .elapsedTime(LocalTime.of(1,10))
                .burnKcal(10)
                .dayId(1L)
                .buildDto();
        secondSampleTraining = Training.builder()
                .id(2L)
                .dateTimeOfExecution(LocalDateTime.of(2020, 12, 12, 12, 12))
                .description("description")
                .elapsedTime(LocalTime.of(2,20))
                .burnKcal(20)
                .dayId(2L)
                .build();
        secondSampleTrainingDto = TrainingDto.builder()
                .id(2L)
                .dateTimeOfExecution(LocalDateTime.of(2020, 12, 12, 12, 12))
                .description("description")
                .elapsedTime(LocalTime.of(2,20))
                .burnKcal(20)
                .dayId(2L)
                .buildDto();

        firstTrainingList = Arrays.asList(firstSampleTraining, secondSampleTraining);
        firstTrainingDtoList = Arrays.asList(firstSampleTrainingDto, secondSampleTrainingDto);
    }

    @Test
    void shouldGetTrainingDtoByTrainingId(){
        when(trainingRepository.findById(1L)).thenReturn(Optional.of(firstSampleTraining));

        ApiEntityDto actualTrainingDtoByModelId = trainingService.getModelDtoByModelId(1L);

        assertEquals(firstSampleTrainingDto, actualTrainingDtoByModelId);
        assertNotEquals(secondSampleTrainingDto, actualTrainingDtoByModelId);
    }

    @Test
    void shouldGetTrainingsSummaryByTrainings(){
        TrainingsSummary expectedTrainingsSummary = new TrainingsSummary(
                firstTrainingDtoList.stream()
                        .map(trainingDto -> (ApiEntityDto)trainingDto)
                        .collect(Collectors.toList()),
                30,
                LocalTime.of(3,30));

        TrainingsSummary actualTrainingsSummary =
                trainingService.getTrainingsSummaryByTrainings(firstTrainingList);

        assertEquals(expectedTrainingsSummary, actualTrainingsSummary);
    }

    @Test
    void shouldGetTrainingsSummaryByDayId(){
        when(trainingRepository.findTrainingListByDayIdAndUserId(1L, 1L))
                .thenReturn(Optional.ofNullable(firstTrainingList));

        TrainingsSummary expectedTrainingsSummary = new TrainingsSummary(
                firstTrainingDtoList.stream()
                        .map(trainingDto -> (ApiEntityDto)trainingDto)
                        .collect(Collectors.toList()),
                30,
                LocalTime.of(3,30));

        TrainingsSummary actualTrainingsSummaryByDayId =
                trainingService.getTrainingsSummaryByDayId(1L, 1L);

        assertEquals(expectedTrainingsSummary, actualTrainingsSummaryByDayId);
    }

    @Test
    void shouldGetTrainingSummaryByDateAndUserId(){
        when(trainingRepository.findTrainingListByDateAndUserId(LocalDate.of(2020, 12,12),
                1L)).thenReturn(firstTrainingList);

        TrainingsSummary expectedTrainingsSummary = new TrainingsSummary(
                firstTrainingDtoList.stream()
                        .map(trainingDto -> (ApiEntityDto)trainingDto)
                        .collect(Collectors.toList()),
                30,
                LocalTime.of(3,30));

        TrainingsSummary actualTrainingSummaryByDateAndUserId =
                trainingService.getTrainingSummaryByDateAndUserId("2020-12-12", 1L);

        assertEquals(expectedTrainingsSummary, actualTrainingSummaryByDateAndUserId);
    }

    @Test
    void shouldGetTrainingDtoByDayId(){
        when(trainingRepository.findTrainingListByDayId(1L)).thenReturn(firstTrainingList);

        List<TrainingDto> actualTrainingsDtoByDayId = trainingService.getTrainingsDtoByDayId(1L);

        assertEquals(firstTrainingDtoList, actualTrainingsDtoByDayId);
    }
}