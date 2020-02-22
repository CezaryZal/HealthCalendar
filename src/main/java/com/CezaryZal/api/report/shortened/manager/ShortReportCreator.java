package com.CezaryZal.api.report.shortened.manager;

import com.CezaryZal.api.day.model.ObjectToSaveDay;
import com.CezaryZal.api.meal.manager.MealService;
import com.CezaryZal.api.user.limits.manager.DailyLimitsService;
import com.CezaryZal.api.user.limits.model.DailyLimitsTmp;
import com.CezaryZal.api.report.shortened.model.entity.ShortReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShortReportCreator {

    private final MealService mealService;
    private final DailyLimitsService dailyLimitsService;

    @Autowired
    public ShortReportCreator(MealService mealService,
                              DailyLimitsService dailyLimitsService) {
        this.mealService = mealService;
        this.dailyLimitsService = dailyLimitsService;
    }

    ShortReport createNewShortReport(ObjectToSaveDay saveDay)  {
        return ShortReport.builder()
                .date(saveDay.getDate())
                .isAchievedKcal(false)
                .isAchievedDrink(false)
                .isAlcohol(saveDay.getPortionsAlcohol() != 0)
                .isSnacks(saveDay.getPortionsSnack() != 0)
                .build();
    }

    ShortReport createShortReportToUpdateByDay(ObjectToSaveDay saveDay, Long dayId, Long shortReportId)  {
        DailyLimitsTmp dailyLimits = dailyLimitsService.getDailyLimitsByUserId(saveDay.getUserId());
        int sumOfKcal = mealService.getKcalByDayId(dayId);
        return ShortReport.builder()
                .id(shortReportId)
                .date(saveDay.getDate())
                .isAchievedKcal(dailyLimitsService.checkIsAchievedKcal(
                        dailyLimits.getKcalDemandPerDay(), sumOfKcal))
                .isAchievedDrink(dailyLimitsService.checkIsAchievedDrink(
                        dailyLimits.getDrinkDemandPerDay(), saveDay.getPortionsDrink()))
                .isAlcohol(saveDay.getPortionsAlcohol() != 0)
                .isSnacks(saveDay.getPortionsSnack() != 0)
                .build();
    }
}
