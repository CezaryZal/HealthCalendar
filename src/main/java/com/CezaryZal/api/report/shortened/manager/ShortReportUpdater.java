package com.CezaryZal.api.report.shortened.manager;

import com.CezaryZal.api.day.model.ObjectToSaveDay;
import com.CezaryZal.api.day.model.entity.Day;
import com.CezaryZal.api.day.repo.DayRepository;
import com.CezaryZal.api.meal.repo.MealRepository;
import com.CezaryZal.api.report.shortened.model.entity.ShortReport;
import com.CezaryZal.api.report.shortened.repo.ShortReportRepository;
import com.CezaryZal.api.user.limits.manager.DailyLimitsService;
import com.CezaryZal.api.user.limits.model.DailyLimits;
import com.CezaryZal.exceptions.not.found.DayNotFoundException;
import com.CezaryZal.exceptions.not.found.ShortReportNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ShortReportUpdater {

    private final MealRepository mealRepository;
    private final DailyLimitsService dailyLimitsService;
    private final ShortReportRepository shortReportRepository;
    private final DayRepository dayRepository;

    @Autowired
    public ShortReportUpdater(MealRepository mealRepository,
                              DailyLimitsService dailyLimitsService,
                              ShortReportRepository shortReportRepository,
                              DayRepository dayRepository) {
        this.mealRepository = mealRepository;
        this.dailyLimitsService = dailyLimitsService;
        this.shortReportRepository = shortReportRepository;
        this.dayRepository = dayRepository;
    }

    public void updateShortReportByDayId(Long dayId) {
        Day findDay = getDayFromDBByDayId(dayId);
        Long shortReportId = getShortReportId(findDay.getDate(), findDay.getUserId());
        ShortReport updatedShortReport = createShortReportToUpdateByDay(findDay, shortReportId);
        shortReportRepository.save(updatedShortReport);
    }

    public ShortReport updateShortReportByObjectToSaveDay(ObjectToSaveDay objectToSaveDay, Long dayId){
        Long shortReportId = getShortReportId(objectToSaveDay.getDate(), objectToSaveDay.getUserId());
        return createShortReportToUpdateByDay(objectToSaveDay,dayId, shortReportId);
    }

    private Day getDayFromDBByDayId(Long dayId){
        return dayRepository.findById(dayId)
                .orElseThrow(() -> new DayNotFoundException("Day not found by id"));
    }

    private Long getShortReportId(LocalDate date, Long userId){
        return shortReportRepository.getIdByDateAndUserId(date, userId)
                .orElseThrow(() -> new ShortReportNotFoundException("Short report not found by date and user id"));
    }

    private ShortReport createShortReportToUpdateByDay(ObjectToSaveDay saveDay, Long dayId, Long shortReportId) {
        DailyLimits dailyLimits = getDailyLimits(saveDay.getUserId());
        return ShortReport.builder()
                .id(shortReportId)
                .date(saveDay.getDate())
                .isAchievedKcal(dailyLimitsService.checkIsAchievedKcal(
                        dailyLimits.getKcalDemandPerDay(), getSumOfKcalFromMealRepository(dayId)))
                .isAchievedDrink(dailyLimitsService.checkIsAchievedDrink(
                        dailyLimits.getDrinkDemandPerDay(), saveDay.getPortionsDrink()))
                .isAlcohol(saveDay.getPortionsAlcohol() != 0)
                .isSnacks(saveDay.getPortionsSnack() != 0)
                .build();
    }

    private ShortReport createShortReportToUpdateByDay(Day day, Long shortReportId) {
        DailyLimits dailyLimits = getDailyLimits(day.getUserId());
        return ShortReport.builder()
                .id(shortReportId)
                .date(day.getDate())
                .isAchievedKcal(dailyLimitsService.checkIsAchievedKcal(
                        dailyLimits.getKcalDemandPerDay(), getSumOfKcalFromMealRepository(day.getId())))
                .isAchievedDrink(dailyLimitsService.checkIsAchievedDrink(
                        dailyLimits.getDrinkDemandPerDay(), day.getPortionsDrink()))
                .isAlcohol(day.getPortionsAlcohol() != 0)
                .isSnacks(day.getPortionsSnack() != 0)
                .build();
    }

    private DailyLimits getDailyLimits(Long userId){
        return dailyLimitsService.getDailyLimitsByUserId(userId);
    }

    private int getSumOfKcalFromMealRepository(Long dayId){
        return mealRepository.getKcal(dayId)
                .orElse(0);
    }
}
