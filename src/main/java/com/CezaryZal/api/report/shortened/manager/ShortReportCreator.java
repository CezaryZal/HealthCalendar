package com.CezaryZal.api.report.shortened.manager;

import com.CezaryZal.api.day.model.ObjectToSaveDay;
import com.CezaryZal.api.limits.manager.DailyLimitsService;
import com.CezaryZal.api.limits.manager.LimitsChecker;
import com.CezaryZal.api.limits.model.LimitsCleanDate;
import com.CezaryZal.api.meal.manager.MealService;
import com.CezaryZal.api.report.shortened.model.entity.ShortReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShortReportCreator {

    private final DailyLimitsService dailyLimitsService;
    private final LimitsChecker limitsChecker;
    private final MealService mealService;

    @Autowired
    public ShortReportCreator(DailyLimitsService dailyLimitsService,
                              LimitsChecker limitsChecker,
                              MealService mealService) {
        this.dailyLimitsService = dailyLimitsService;
        this.limitsChecker = limitsChecker;
        this.mealService = mealService;
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

    ShortReport createShortReportToUpdateRecordByDay(ObjectToSaveDay saveDay, Long dayId, Long shortReportId)  {
        LimitsCleanDate limitsCleanDate = dailyLimitsService.getLimitsCleanDateByUserId(saveDay.getUserId());
        int sumOfKcal = mealService.getKcalByDayId(dayId);
        return ShortReport.builder()
                .id(shortReportId)
                .date(saveDay.getDate())
                .isAchievedKcal(limitsChecker.checkIsAchievedKcal(
                        limitsCleanDate.getKcalDemandPerDay(), sumOfKcal))
                .isAchievedDrink(limitsChecker.checkIsAchievedDrink(
                        limitsCleanDate.getDrinkDemandPerDay(), saveDay.getPortionsDrink()))
                .isAlcohol(saveDay.getPortionsAlcohol() != 0)
                .isSnacks(saveDay.getPortionsSnack() != 0)
                .build();
    }
}
