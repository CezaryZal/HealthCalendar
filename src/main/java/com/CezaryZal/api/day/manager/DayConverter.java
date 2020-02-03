package com.CezaryZal.api.day.manager;

import com.CezaryZal.api.day.model.DayDto;
import com.CezaryZal.api.day.model.entity.Day;
import com.CezaryZal.api.meal.manager.MealService;
import com.CezaryZal.api.note.manager.NoteService;
import com.CezaryZal.api.report.shortened.manager.ShortReportService;
import com.CezaryZal.api.training.manager.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DayConverter {

    private final MealService mealService;
    private final NoteService noteService;
    private final TrainingService trainingService;
    private final ShortReportService shortReportService;

    @Autowired
    public DayConverter(MealService mealService,
                        NoteService noteService,
                        TrainingService trainingService,
                        ShortReportService shortReportService) {
        this.mealService = mealService;
        this.noteService = noteService;
        this.trainingService = trainingService;
        this.shortReportService = shortReportService;
    }

    DayDto mappingDayToDto(Day day){
        return DayDto.builder()
                .id(day.getId())
                .date(day.getDate())
                .userId(day.getUserId())
                .portionsDrink(day.getPortionsDrink())
                .portionsAlcohol(day.getPortionsAlcohol())
                .portionsSnack(day.getPortionsSnack())
                .listMeal(mealService.getMealsDtoByDayIdOrNull(day.getId()))
                .listTrainings(trainingService.getTrainingsDtoByDayId(day.getId()))
                .listNotes(noteService.getNotesDtoByDay(day.getId()))
                .shortReport(shortReportService.getShortReportDtoById(day.getId()))
                .build();
    }
}
