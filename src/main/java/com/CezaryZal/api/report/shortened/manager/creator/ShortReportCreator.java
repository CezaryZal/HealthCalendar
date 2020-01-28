package com.CezaryZal.api.report.shortened.manager.creator;

import com.CezaryZal.api.day.model.ObjectToSaveDay;
import com.CezaryZal.api.limits.manager.checker.LimitsChecker;
import com.CezaryZal.api.limits.manager.repo.DailyLimitsRepoService;
import com.CezaryZal.api.limits.model.LimitsCleanDate;
import com.CezaryZal.api.meal.model.entity.Meal;
import com.CezaryZal.api.meal.manager.MealService;
import com.CezaryZal.api.meal.manager.repo.MealRepoService;
import com.CezaryZal.api.report.shortened.manager.repo.ShortReportRepoService;
import com.CezaryZal.api.report.shortened.model.entity.ShortReport;
import com.CezaryZal.api.user.model.entity.User;
import com.CezaryZal.api.user.manager.repo.UserRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShortReportCreator {

    private final ShortReportRepoService shortReportRepoService;
    private final DailyLimitsRepoService dailyLimitsRepoService;
    private final LimitsChecker limitsChecker;
    private final MealService mealService;
    private final MealRepoService mealRepoService;

    @Autowired
    public ShortReportCreator(ShortReportRepoService shortReportRepoService,
                              DailyLimitsRepoService dailyLimitsRepoService,
                              LimitsChecker limitsChecker,
                              MealService mealService,
                              MealRepoService mealRepoService) {
        this.shortReportRepoService = shortReportRepoService;
        this.dailyLimitsRepoService = dailyLimitsRepoService;
        this.limitsChecker = limitsChecker;
        this.mealService = mealService;
        this.mealRepoService = mealRepoService;
    }

    public ShortReport createToUpdateRecordByDay(ObjectToSaveDay saveDay)  {
        Long shortReportId = shortReportRepoService.getShortReportIdByDateAndUserId(
                saveDay.getDate(), saveDay.getUserId());
        LimitsCleanDate limitsCleanDate = dailyLimitsRepoService.getLimitsCleanDateByUserId(saveDay.getUserId());
        List<Meal> listMealByDayId = mealRepoService.getListMealByDayId(saveDay.getUserId());
        int sumOfKcal = mealService.getDailyDietByListMeal(listMealByDayId)
                .getSumOfKcal();
        return ShortReport.Builder.builder()
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
