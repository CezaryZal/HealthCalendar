package com.CezaryZal.api.shortday.manager.mapper;

import com.CezaryZal.api.day.entity.api.DayApi;
import com.CezaryZal.api.shortday.entity.ShortDay;
import org.springframework.stereotype.Service;

@Service
public class DayApiToShortDayConverter {

    public ShortDay create(DayApi day)  {

        return new ShortDay(
                day.getId(),
                day.getUserId(),
                day.getDate(),
                day.isAchievedKcal(),
                day.isAchievedDrink(),
                day.getPortionsAlcohol() != 0,
                day.getPortionsSnack() != 0
        );
    }

}
