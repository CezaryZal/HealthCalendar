package com.CezaryZal.api.day.manager.mapper;

import com.CezaryZal.api.day.entity.day.Day;
import com.CezaryZal.api.day.entity.day.DayBasic;
import org.springframework.stereotype.Service;

@Service
public class DayToDayBasicConverter {

    public DayBasic mappingEntity(Day day){
        return new DayBasic(
                day.getId(),
                day.getDate(),
                day.getUserId(),
                day.getPortionsDrink(),
                day.getPortionsAlcohol(),
                day.getPortionsSnack()
        );
    }
}
