package com.CezaryZal.api.report.manager;

import com.CezaryZal.api.body.manager.BodySizeService;
import com.CezaryZal.api.limits.manager.DailyLimitsService;
import com.CezaryZal.api.limits.model.LimitsCleanDate;
import com.CezaryZal.api.meal.model.DailyDiet;
import com.CezaryZal.api.note.manager.NoteService;
import com.CezaryZal.api.report.model.FormReport;
import com.CezaryZal.api.day.model.entity.Day;
import com.CezaryZal.api.limits.manager.DailyLimitsChecker;
import com.CezaryZal.api.meal.manager.MealService;
import com.CezaryZal.api.report.shortened.manager.ShortReportService;
import com.CezaryZal.api.training.manager.TrainingService;
import com.CezaryZal.api.user.manager.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportCreator {

    private final DailyLimitsChecker dailyLimitsChecker;
    private final MealService mealService;
    private final BodySizeService bodySizeService;
    private final TrainingService trainingService;
    private final NoteService noteService;
    private final ShortReportService shortReportService;
    private final DailyLimitsService dailyLimitsService;
    private final UserService userService;

    @Autowired
    public ReportCreator(DailyLimitsChecker dailyLimitsChecker,
                         MealService mealService,
                         BodySizeService bodySizeService,
                         TrainingService trainingService,
                         NoteService noteService,
                         ShortReportService shortReportService,
                         DailyLimitsService dailyLimitsService,
                         UserService userService) {
        this.dailyLimitsChecker = dailyLimitsChecker;
        this.mealService = mealService;
        this.bodySizeService = bodySizeService;
        this.trainingService = trainingService;
        this.noteService = noteService;
        this.shortReportService = shortReportService;
        this.dailyLimitsService = dailyLimitsService;
        this.userService = userService;
    }

    FormReport createFormReportByDayAndUser(Day day, Long userId, boolean isLongReport){
        String dateLastMeasureBody = bodySizeService.getDateLastMeasureByUserId(userId)
                .map(String::valueOf)
                .orElse("The body measurement has not been done ");

        LimitsCleanDate limitsCleanDate = dailyLimitsService.getLimitsCleanDateByUserId(userId);
        String nickByUserId = userService.getNickByUserId(userId);
        boolean isAchievedDrink = dailyLimitsChecker.checkIsAchievedDrink(
                limitsCleanDate.getDrinkDemandPerDay(), day.getPortionsDrink());
        if (isLongReport){
            DailyDiet dailyDietByListMeal = mealService.getDailyDietByListMeal(day.getListMealsDB());
            boolean isAchievedKcal = dailyLimitsChecker.checkIsAchievedKcal(
                    limitsCleanDate.getKcalDemandPerDay(), dailyDietByListMeal.getSumOfKcal());
            return FormReport.builder()
                    .id(day.getId())
                    .date(day.getDate())
                    .userId(userId)
                    .portionsDrink(day.getPortionsDrink())
                    .portionsAlcohol(day.getPortionsAlcohol())
                    .portionsSnack(day.getPortionsSnack())
                    .nick(nickByUserId)
                    .lastDateMeasureBody(dateLastMeasureBody)
                    .isAchievedDrink(isAchievedDrink)
                    .isAchievedKcal(isAchievedKcal)
                    .dailyDiet(dailyDietByListMeal)
                    .trainings(trainingService.getTrainingsSummaryByTrainings(day.getListTrainingsDB()))
                    .listHeaders(noteService.getHeadersForLongReportByDayId(day.getId()))
                    .listShortsDayDto(shortReportService.getShortReportsByDateAndUserId(day.getDate(), userId))
                    .buildLongReport();
        }
        int sumOfKcal = mealService.getKcalByDayId(day.getId());
        boolean isAchievedKcal = dailyLimitsChecker.checkIsAchievedKcal(
                limitsCleanDate.getKcalDemandPerDay(), sumOfKcal);
        return FormReport.builder()
                .id(day.getId())
                .date(day.getDate())
                .userId(userId)
                .portionsDrink(day.getPortionsDrink())
                .portionsAlcohol(day.getPortionsAlcohol())
                .portionsSnack(day.getPortionsSnack())
                .nick(nickByUserId)
                .lastDateMeasureBody(dateLastMeasureBody)
                .isAchievedDrink(isAchievedDrink)
                .isAchievedKcal(isAchievedKcal)
                .buildReport();
    }
}
