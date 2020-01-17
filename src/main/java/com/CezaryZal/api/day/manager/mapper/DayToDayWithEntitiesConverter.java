package com.CezaryZal.api.day.manager.mapper;

import com.CezaryZal.api.day.entity.day.Day;
import com.CezaryZal.api.day.entity.day.DayWithConnectedEntities;
import org.springframework.stereotype.Service;

@Service
public class DayToDayWithEntitiesConverter {

    public DayWithConnectedEntities mappingEntity(Day day){
        return new DayWithConnectedEntities(
                day.getId(),
                day.getDate(),
                day.getUserId(),
                day.getPortionsDrink(),
                day.getPortionsAlcohol(),
                day.getPortionsSnack(),
                day.getListMealsDB(),
                day.getListTrainingsDB(),
                day.getListNotesDB(),
                day.getShortDay()
        );
    }
}
