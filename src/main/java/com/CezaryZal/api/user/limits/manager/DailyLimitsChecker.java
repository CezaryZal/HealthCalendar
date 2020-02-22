package com.CezaryZal.api.user.limits.manager;

import org.springframework.stereotype.Service;

@Service
public class DailyLimitsChecker {

    private final int PORTION_OF_DRINK = 250;
    private final double LIMIT_OF_EAT_KCAL = 0.05; // 5%

    boolean checkIsAchievedDrink(int drinkDemandPerDay, int portionsDrink) {
        return drinkDemandPerDay <= portionsDrink * PORTION_OF_DRINK;
    }

    boolean checkIsAchievedKcal(int kcalDemand, int sumOfKcal) {
        return checkIfEatenTooMuch(kcalDemand, sumOfKcal) && checkIfEatenTooLittle(kcalDemand, sumOfKcal);
    }

    private boolean checkIfEatenTooMuch(int kcalDemand, int sumOfKcal){
        return sumOfKcal >= kcalDemand + kcalDemand * LIMIT_OF_EAT_KCAL;
    }

    private boolean checkIfEatenTooLittle(int kcalDemand, int sumOfKcal){
        return sumOfKcal <= kcalDemand - kcalDemand * LIMIT_OF_EAT_KCAL;
    }
}
