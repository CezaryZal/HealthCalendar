package com.CezaryZal.api.report.shortened.manager.creator;

import com.CezaryZal.api.day.model.ObjectToSaveDay;
import com.CezaryZal.api.limits.manager.DailyLimitsService;
import com.CezaryZal.api.limits.manager.LimitsChecker;
import com.CezaryZal.api.limits.model.LimitsCleanDate;
import com.CezaryZal.api.meal.manager.repo.MealRepoService;
import com.CezaryZal.api.report.shortened.manager.repo.ShortReportRepoService;
import com.CezaryZal.api.report.shortened.model.entity.ShortReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShortReportCreator {

    private final ShortReportRepoService shortReportRepoService;
    private final DailyLimitsService dailyLimitsService;
    private final LimitsChecker limitsChecker;
    private final MealRepoService mealRepoService;

    @Autowired
    public ShortReportCreator(ShortReportRepoService shortReportRepoService,
                              DailyLimitsService dailyLimitsService,
                              LimitsChecker limitsChecker,
                              MealRepoService mealRepoService) {
        this.shortReportRepoService = shortReportRepoService;
        this.dailyLimitsService = dailyLimitsService;
        this.limitsChecker = limitsChecker;
        this.mealRepoService = mealRepoService;
    }

    public ShortReport createNewShortReport(ObjectToSaveDay saveDay)  {
        return ShortReport.builder()
                .date(saveDay.getDate())
                .isAchievedKcal(false)
                .isAchievedDrink(false)
                .isAlcohol(saveDay.getPortionsAlcohol() != 0)
                .isSnacks(saveDay.getPortionsSnack() != 0)
                .build();
    }

    public ShortReport createToUpdateRecordByDay(ObjectToSaveDay saveDay, Long dayId)  {
        Long shortReportId = shortReportRepoService.getShortReportIdByDateAndUserId(
                saveDay.getDate(), saveDay.getUserId());
        LimitsCleanDate limitsCleanDate = dailyLimitsService.getLimitsCleanDateByUserId(saveDay.getUserId());
        int sumOfKcal = mealRepoService.getKcalByDayId(dayId);
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
