package com.CezaryZal.api.day.manager.creator;

import com.CezaryZal.api.day.entity.api.DayApi;
import com.CezaryZal.api.day.entity.day.Day;
import com.CezaryZal.api.shortday.entity.ShortDay;
import org.springframework.stereotype.Service;

@Service
public class DayCreator {

    public Day createByDayApiAndShortDay(DayApi dayApi, ShortDay shortDay){
        return new Day(
                dayApi.getId(),
                dayApi.getDate(),
                dayApi.getUserId(),
                dayApi.getPortionsDrink(),
                dayApi.getPortionsAlcohol(),
                dayApi.getPortionsSnack(),
                shortDay
        );
    }
}
