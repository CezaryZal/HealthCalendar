package com.CezaryZal.api.report.shortened.manager.creator;

import com.CezaryZal.api.day.model.ObjectToSaveDay;
import com.CezaryZal.api.limits.manager.checker.LimitsChecker;
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
    private final LimitsChecker limitsChecker;
    private final UserRepoService userRepoService;
    private final MealService mealService;
    private final MealRepoService mealRepoService;

    @Autowired
    public ShortReportCreator(ShortReportRepoService shortReportRepoService, LimitsChecker limitsChecker,
                              UserRepoService userRepoService, MealService mealService, MealRepoService mealRepoService) {
        this.shortReportRepoService = shortReportRepoService;
        this.limitsChecker = limitsChecker;
        this.userRepoService = userRepoService;
        this.mealService = mealService;
        this.mealRepoService = mealRepoService;
    }

    public ShortReport createByDay(ObjectToSaveDay saveDay)  {
        ShortReport shortReport = shortReportRepoService.getShortReportByDateAndUserId(saveDay.getDate(), saveDay.getUserId());
        User user = userRepoService.getUserById(saveDay.getUserId());
        List<Meal> listMealByDayId = mealRepoService.getListMealByDayId(saveDay.getUserId());
        int sumOfKcal = mealService.getDailyDietByListMeal(listMealByDayId)
                .getSumOfKcal();
        return ShortReport.Builder.builder()
                .id(shortReport.getId())
                .date(saveDay.getDate())
                .isAchievedKcal(limitsChecker.checkIsAchievedKcal(
                        user.getDailyLimits().getKcalDemandPerDay(),
                        sumOfKcal))
                .isAchievedDrink(limitsChecker.checkIsAchievedDrink(
                        user.getDailyLimits().getDrinkDemandPerDay(),
                        saveDay.getPortionsDrink()))
                .isAlcohol(saveDay.getPortionsAlcohol() != 0)
                .isSnacks(saveDay.getPortionsSnack() != 0)
                .build();
    }
}
