package com.CezaryZal.api.day.manager.mapper;

import com.CezaryZal.api.day.model.entity.Day;
import com.CezaryZal.api.day.model.DayDto;
import org.springframework.stereotype.Service;

@Service
public class DayToDtoConverter {

    public DayDto mappingEntity(Day day){
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
}
