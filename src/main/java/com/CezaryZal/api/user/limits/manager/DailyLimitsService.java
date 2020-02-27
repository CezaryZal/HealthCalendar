package com.CezaryZal.api.user.limits.manager;

import com.CezaryZal.api.user.limits.model.DailyLimits;
import com.CezaryZal.api.user.repo.UserRepository;
import com.CezaryZal.constants.objects.DefaultDailyLimits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DailyLimitsService {

    private final UserRepository userRepository;
    private final DailyLimitsChecker dailyLimitsChecker;

    @Autowired
    public DailyLimitsService(UserRepository userRepository,
                              DailyLimitsChecker dailyLimitsChecker) {
        this.userRepository = userRepository;
        this.dailyLimitsChecker = dailyLimitsChecker;
    }

    public DailyLimits getDailyLimitsByUserId(Long id) {
        return userRepository.getDailyLimits(id)
                .orElseGet(() -> DefaultDailyLimits.getDefaultDailyLimits().getDailyLimitsTmp());
    }

    public boolean checkIsAchievedDrink(int drinkDemandPerDay, int portionsDrink){
        return dailyLimitsChecker.checkIsAchievedDrink(drinkDemandPerDay, portionsDrink);
    }

    public boolean checkIsAchievedKcal(int kcalDemand, int sumOfKcal) {
        return dailyLimitsChecker.checkIsAchievedKcal(kcalDemand, sumOfKcal);
    }
}
