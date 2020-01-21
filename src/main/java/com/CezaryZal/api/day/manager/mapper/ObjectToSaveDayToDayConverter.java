package com.CezaryZal.api.day.manager.mapper;

import com.CezaryZal.api.day.model.entity.Day;
import com.CezaryZal.api.day.model.ObjectToSaveDay;
import org.springframework.stereotype.Service;

@Service
public class ObjectToSaveDayToDayConverter {

    public Day mappingEntity(ObjectToSaveDay day){
        return new Day(
                day.getDate(),
                day.getUserId(),
                day.getPortionsDrink(),
                day.getPortionsAlcohol(),
                day.getPortionsSnack()
        );
    }
}
