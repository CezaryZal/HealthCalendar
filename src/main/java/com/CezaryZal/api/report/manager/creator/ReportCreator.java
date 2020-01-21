package com.CezaryZal.api.report.manager.creator;

import com.CezaryZal.api.body.manager.repo.BodySizeRepoService;
import com.CezaryZal.api.report.model.Report;
import com.CezaryZal.api.day.model.entity.Day;
import com.CezaryZal.api.limits.manager.checker.LimitsChecker;
import com.CezaryZal.api.meal.manager.MealService;
import com.CezaryZal.api.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ReportCreator {

    private final LimitsChecker limitsChecker;
    private final MealService mealService;
    private final BodySizeRepoService bodySizeRepoService;

    @Autowired
    public ReportCreator(LimitsChecker limitsChecker,
                         MealService mealService,
                         BodySizeRepoService bodySizeRepoService) {
        this.limitsChecker = limitsChecker;
        this.mealService = mealService;
        this.bodySizeRepoService = bodySizeRepoService;
    }

    public Report createByDayAndUser (Day day, User user){
        int sumOfKcal = mealService.getDailyDietByListMeal(day.getListMealsDB()).getSumOfKcal();
        LocalDate dateLastMeasureBody = bodySizeRepoService.getDateLastMeasureByUserId(user.getId());

        return new Report(
                day.getId(),
                day.getDate(),
                user.getId(),
                day.getPortionsDrink(),
                day.getPortionsAlcohol(),
                day.getPortionsSnack(),
                user.getNick(),
                dateLastMeasureBody,
                limitsChecker.checkIsAchievedDrink(
                        user.getDailyLimits().getDrinkDemandPerDay(),
                        day.getPortionsDrink()),
                limitsChecker.checkIsAchievedKcal(
                        user.getDailyLimits().getKcalDemandPerDay(),
                        sumOfKcal)
        );
    }
}
