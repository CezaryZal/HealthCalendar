package com.CezaryZal.api.shortday.manager.creator;

import com.CezaryZal.api.day.entity.api.DayApi;
import com.CezaryZal.api.shortday.entity.ShortDay;
import com.CezaryZal.api.shortday.manager.repo.ShortDayRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShortDayCreator {

    private final ShortDayRepoService shortDayRepoService;

    @Autowired
    public ShortDayCreator(ShortDayRepoService shortDayRepoService) {
        this.shortDayRepoService = shortDayRepoService;
    }

    public ShortDay createByDay(DayApi day)  {
        ShortDay shortDay = shortDayRepoService.getShortDayByDateAndUserId(day.getDate(), day.getUserId());

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
