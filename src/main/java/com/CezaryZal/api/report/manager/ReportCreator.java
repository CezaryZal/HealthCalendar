package com.CezaryZal.api.report.manager;

import com.CezaryZal.api.ApiEntity;
import com.CezaryZal.api.body.manager.BodySizeService;
import com.CezaryZal.api.meal.model.DailyDiet;
import com.CezaryZal.api.note.manager.NoteService;
import com.CezaryZal.api.report.model.BasicReport;
import com.CezaryZal.api.user.limits.manager.DailyLimitsService;
import com.CezaryZal.api.user.limits.model.DailyLimits;
import com.CezaryZal.api.report.model.FormReport;
import com.CezaryZal.api.day.model.entity.Day;
import com.CezaryZal.api.meal.manager.MealService;
import com.CezaryZal.api.report.shortened.manager.ShortReportService;
import com.CezaryZal.api.training.manager.TrainingService;
import com.CezaryZal.api.user.manager.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportCreator {

    private final MealService mealService;
    private final BodySizeService bodySizeService;
    private final TrainingService trainingService;
    private final NoteService noteService;
    private final ShortReportService shortReportService;
    private final UserService userService;
    private final DailyLimitsService dailyLimitsService;

    @Autowired
    public ReportCreator(MealService mealService,
                         BodySizeService bodySizeService,
                         TrainingService trainingService,
                         NoteService noteService,
                         ShortReportService shortReportService,
                         UserService userService,
                         DailyLimitsService dailyLimitsService) {
        this.mealService = mealService;
        this.bodySizeService = bodySizeService;
        this.trainingService = trainingService;
        this.noteService = noteService;
        this.shortReportService = shortReportService;
        this.userService = userService;
        this.dailyLimitsService = dailyLimitsService;
    }

    BasicReport creatBasicReport(String loginName){
        Long userIdByLoginName = userService.getIdByLoginName(loginName);

        return new BasicReport(userIdByLoginName,
                userService.getNickByUserId(userIdByLoginName),
                getDateOfLastMeasureBody(userIdByLoginName));
    }

    FormReport createFormReportByDayAndUser(Day day, Long userId, boolean isLongReport){
        String dateOfLastMeasureBody = getDateOfLastMeasureBody(userId);

        DailyLimits dailyLimits = dailyLimitsService.getDailyLimitsByUserId(userId);
        String nickByUserId = userService.getNickByUserId(userId);
        boolean isAchievedDrink = dailyLimitsService.checkIsAchievedDrink(
                dailyLimits.getDrinkDemandPerDay(), day.getPortionsDrink());
        if (isLongReport){
            List<ApiEntity> meals = new ArrayList<>(day.getListMealsDB());
            DailyDiet dailyDietByListMeal = mealService.getDailyDietByListMeal(meals);
            boolean isAchievedKcal = dailyLimitsService.checkIsAchievedKcal(
                    dailyLimits.getKcalDemandPerDay(), dailyDietByListMeal.getSumOfKcal());
            return FormReport.builder()
                    .id(day.getId())
                    .date(day.getDate())
                    .userId(userId)
                    .portionsDrink(day.getPortionsDrink())
                    .portionsAlcohol(day.getPortionsAlcohol())
                    .portionsSnack(day.getPortionsSnack())
                    .nick(nickByUserId)
                    .lastDateMeasureBody(dateOfLastMeasureBody)
                    .isAchievedDrink(isAchievedDrink)
                    .isAchievedKcal(isAchievedKcal)
                    .dailyDiet(dailyDietByListMeal)
                    .trainings(trainingService.getTrainingsSummaryByTrainings(day.getListTrainingsDB()))
                    .listHeaders(noteService.getHeadersForLongReportByDayId(day.getId()))
                    .listShortsDayDto(shortReportService.getShortReportsByDateAndUserId(day.getDate(), userId))
                    .buildLongReport();
        }
        int sumOfKcal = mealService.getKcalByDayId(day.getId());
        boolean isAchievedKcal = dailyLimitsService.checkIsAchievedKcal(
                dailyLimits.getKcalDemandPerDay(), sumOfKcal);
        return FormReport.builder()
                .id(day.getId())
                .date(day.getDate())
                .userId(userId)
                .portionsDrink(day.getPortionsDrink())
                .portionsAlcohol(day.getPortionsAlcohol())
                .portionsSnack(day.getPortionsSnack())
                .nick(nickByUserId)
                .lastDateMeasureBody(dateOfLastMeasureBody)
                .isAchievedDrink(isAchievedDrink)
                .isAchievedKcal(isAchievedKcal)
                .buildReport();
    }

    private String getDateOfLastMeasureBody(Long userId) {
        return bodySizeService.getDateOfLastMeasureByUserId(userId)
                    .map(String::valueOf)
                    .orElse("The body measurement has not been done ");
    }
}
