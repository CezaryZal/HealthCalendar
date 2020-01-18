package com.CezaryZal.api.day.manager.mapper;

import com.CezaryZal.api.day.entity.day.Day;
import com.CezaryZal.api.day.entity.day.DayBasic;
import org.springframework.stereotype.Service;

@Service
public class DayBasicToDayConverter {

    public Day mappingEntity(DayBasic day){
        return new Day(
                day.getDate(),
                day.getUserId(),
                day.getPortionsDrink(),
                day.getPortionsAlcohol(),
                day.getPortionsSnack()
        );
    }
}
