package com.CezaryZal.api.day.manager.mapper;

import com.CezaryZal.api.day.model.DayDto;
import com.CezaryZal.api.day.model.ObjectToSaveDay;
import com.CezaryZal.api.day.model.entity.Day;
import org.springframework.stereotype.Service;

@Service
public class DayConverter {

    public DayDto mappingDayToDto(Day day){
        return DayDto.Builder.builder()
                .id(day.getId())
                .date(day.getDate())
                .userId(day.getUserId())
                .portionsDrink(day.getPortionsDrink())
                .portionsAlcohol(day.getPortionsAlcohol())
                .portionsSnack(day.getPortionsSnack())
                .listMeal(day.getListMealsDB())
                .listTrainings(day.getListTrainingsDB())
                .listNotes(day.getListNotesDB())
                .shortReport(day.getShortReport())
                .build();
    }
}
