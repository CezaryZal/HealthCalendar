package com.CezaryZal.api.shortday.manager.mapper;

import com.CezaryZal.api.shortday.entity.ShortDay;
import com.CezaryZal.api.shortday.entity.ShortDayDto;
import org.springframework.stereotype.Service;

@Service
public class ShortDayToDtoConverter {

    public ShortDayDto mappingEntity(ShortDay shortDay){
        return new ShortDayDto(
                shortDay.getId(),
                shortDay.getUserId(),
                shortDay.getDate(),
                shortDay.isAchievedKcal(),
                shortDay.isAchievedDrink(),
                shortDay.isAlcohol(),
                shortDay.isSnacks()
        );
    }
}
