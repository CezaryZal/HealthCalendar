package com.CezaryZal.api.shortday.manager.creator;

import com.CezaryZal.api.day.entity.api.DayApi;
import com.CezaryZal.api.shortday.entity.ShortDay;
import com.CezaryZal.api.shortday.manager.ShortDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShortDayCreator {

    private final ShortDayService shortDayService;

    @Autowired
    public ShortDayCreator(ShortDayService shortDayService) {
        this.shortDayService = shortDayService;
    }

    public ShortDay createByDay(DayApi day)  {
        ShortDay shortDay = shortDayService.getShortDayByDateAndUserId(day.getDate(), day.getUserId());

        return new ShortDay(
                shortDay.getId(),
                day.getUserId(),
                day.getDate(),
                day.isAchievedKcal(),
                day.isAchievedDrink(),
                day.getPortionsAlcohol() != 0,
                day.getPortionsSnack() != 0
        );
    }
}
