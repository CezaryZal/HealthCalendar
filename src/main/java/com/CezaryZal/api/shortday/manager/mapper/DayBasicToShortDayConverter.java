package com.CezaryZal.api.shortday.manager.mapper;

import com.CezaryZal.api.day.entity.day.DayBasic;
import com.CezaryZal.api.shortday.entity.ShortDay;
import org.springframework.stereotype.Service;

@Service
public class DayBasicToShortDayConverter {

    public ShortDay mappingEntity(DayBasic day)  {

        return new ShortDay(
                day.getId(),
                day.getUserId(),
                day.getDate(),
                false,
                false,
                day.getPortionsAlcohol() != 0,
                day.getPortionsSnack() != 0
        );
    }
}
