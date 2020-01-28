package com.CezaryZal.api.report.manager.creator;

import com.CezaryZal.api.body.manager.repo.BodySizeRepoService;
import com.CezaryZal.api.limits.manager.repo.DailyLimitsRepoService;
import com.CezaryZal.api.limits.model.LimitsCleanDate;
import com.CezaryZal.api.meal.model.DailyDiet;
import com.CezaryZal.api.note.manager.creator.HeadersCreator;
import com.CezaryZal.api.report.model.FormReport;
import com.CezaryZal.api.day.model.entity.Day;
import com.CezaryZal.api.limits.manager.checker.LimitsChecker;
import com.CezaryZal.api.meal.manager.MealService;
import com.CezaryZal.api.report.shortened.manager.ShortReportService;
import com.CezaryZal.api.training.manager.TrainingService;
import com.CezaryZal.api.user.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportCreator {

    private final LimitsChecker limitsChecker;
    private final MealService mealService;
    private final BodySizeRepoService bodySizeRepoService;
    private final TrainingService trainingService;
    private final HeadersCreator headersCreator;
    private final ShortReportService shortReportService;
    private final DailyLimitsRepoService dailyLimitsRepoService;

    @Autowired
    public ReportCreator(LimitsChecker limitsChecker,
                         MealService mealService,
                         BodySizeRepoService bodySizeRepoService,
                         TrainingService trainingService,
                         HeadersCreator headersCreator,
                         ShortReportService shortReportService,
                         DailyLimitsRepoService dailyLimitsRepoService) {
        this.limitsChecker = limitsChecker;
        this.mealService = mealService;
        this.bodySizeRepoService = bodySizeRepoService;
        this.trainingService = trainingService;
        this.headersCreator = headersCreator;
        this.shortReportService = shortReportService;
        this.dailyLimitsRepoService = dailyLimitsRepoService;
    }

    //Zoptymalizować przez pobieranie lilitu bezpośrednio a nie całego użytkownika
    public FormReport createByDayAndUser (Day day, User user, boolean isLongReport){
        String dateLastMeasureBody = bodySizeRepoService.getDateLastMeasureByUserId(user.getId())
                .map(String::valueOf)
                .orElse("Nie wykonano żadnego pomiaru ciała");
        DailyDiet dailyDietByListMeal = mealService.getDailyDietByListMeal(day.getListMealsDB());
        LimitsCleanDate limitsCleanDate = dailyLimitsRepoService.getLimitsCleanDateByUserId(user.getId());
        boolean isAchievedDrink = limitsChecker.checkIsAchievedDrink(
                user.getDailyLimits().getDrinkDemandPerDay(),
                day.getPortionsDrink());
        boolean isAchievedKcal = limitsChecker.checkIsAchievedKcal(
                user.getDailyLimits().getKcalDemandPerDay(),
                dailyDietByListMeal.getSumOfKcal());
        if (isLongReport){
            return FormReport.Builder.builder()
                    .id(day.getId())
                    .date(day.getDate())
                    .userId(user.getId())
                    .portionsDrink(day.getPortionsDrink())
                    .portionsAlcohol(day.getPortionsAlcohol())
                    .portionsSnack(day.getPortionsSnack())
                    .nick(user.getNick())
                    .lastDateMeasureBody(dateLastMeasureBody)
                    .isAchievedDrink(isAchievedDrink)
                    .isAchievedKcal(isAchievedKcal)
                    .dailyDiet(dailyDietByListMeal)
                    .trainings(trainingService.getTrainingsSummaryByTrainings(day.getListTrainingsDB()))
                    .listHeaders(headersCreator.getHeadersByNotes(day.getListNotesDB()))
                    .listShortsDayDto(shortReportService.getShortReportsByDateAndUserId(day.getDate(), user.getId()))
                    .buildLongReport();
        }
        return FormReport.Builder.builder()
                .id(day.getId())
                .date(day.getDate())
                .userId(user.getId())
                .portionsDrink(day.getPortionsDrink())
                .portionsAlcohol(day.getPortionsAlcohol())
                .portionsSnack(day.getPortionsSnack())
                .nick(user.getNick())
                .lastDateMeasureBody(dateLastMeasureBody)
                .isAchievedDrink(isAchievedDrink)
                .isAchievedKcal(isAchievedKcal)
                .buildReport();
    }
}
