package com.CezaryZal.api.day.manager.mapper;

import com.CezaryZal.api.day.model.DayDto;
import com.CezaryZal.api.day.model.ObjectToSaveDay;
import com.CezaryZal.api.day.model.entity.Day;
import org.springframework.stereotype.Service;

@Service
public class DayConverter {

    public DayDto mappingDayToDto(Day day){
        return new DayDto(
                day.getId(),
                day.getDate(),
                day.getUserId(),
                day.getPortionsDrink(),
                day.getPortionsAlcohol(),
                day.getPortionsSnack(),
                day.getListMealsDB(),
                day.getListTrainingsDB(),
                day.getListNotesDB(),
                day.getShortReport()
        );
    }

    public Day mappingObjectToSaveDayToDay(ObjectToSaveDay day){
        return new Day(
                day.getDate(),
                day.getUserId(),
                day.getPortionsDrink(),
                day.getPortionsAlcohol(),
                day.getPortionsSnack()
        );
    }
}
