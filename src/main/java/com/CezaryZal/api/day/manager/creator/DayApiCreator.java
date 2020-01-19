package com.CezaryZal.api.day.manager.creator;

import com.CezaryZal.api.body.manager.BodySizeService;
import com.CezaryZal.api.day.entity.api.DayApi;
import com.CezaryZal.api.day.entity.day.Day;
import com.CezaryZal.api.limits.manager.checker.LimitsChecker;
import com.CezaryZal.api.meal.manager.MealService;
import com.CezaryZal.api.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DayApiCreator {

    private final LimitsChecker limitsChecker;
    private final MealService mealService;
    private final BodySizeService bodySizeService;

    @Autowired
    public DayApiCreator(LimitsChecker limitsChecker, MealService mealService, BodySizeService bodySizeService) {
        this.limitsChecker = limitsChecker;
        this.mealService = mealService;
        this.bodySizeService = bodySizeService;
    }

    public DayApi createByDayAndUser (Day day, User user){
        int sumOfKcal = mealService.getDailyDietByListMeal(day.getListMealsDB()).getSumOfKcal();
        LocalDate dateLastMeasureBody = bodySizeService.getDateLastMeasureByUserId(user.getId());

        return new DayApi(
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
