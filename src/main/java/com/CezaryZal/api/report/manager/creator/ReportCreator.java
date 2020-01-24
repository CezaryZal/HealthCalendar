package com.CezaryZal.api.report.manager.creator;

import com.CezaryZal.api.body.manager.repo.BodySizeRepoService;
import com.CezaryZal.api.meal.model.DailyDiet;
import com.CezaryZal.api.note.manager.creator.HeadersCreator;
import com.CezaryZal.api.report.model.FormReport;
import com.CezaryZal.api.report.model.LongReport;
import com.CezaryZal.api.report.model.Report;
import com.CezaryZal.api.day.model.entity.Day;
import com.CezaryZal.api.limits.manager.checker.LimitsChecker;
import com.CezaryZal.api.meal.manager.MealService;
import com.CezaryZal.api.report.shortened.manager.ShortReportService;
import com.CezaryZal.api.training.manager.TrainingService;
import com.CezaryZal.api.user.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ReportCreator {

    private final LimitsChecker limitsChecker;
    private final MealService mealService;
    private final BodySizeRepoService bodySizeRepoService;
    private final TrainingService trainingService;
    private final HeadersCreator headersCreator;
    private final ShortReportService shortReportService;

    @Autowired
    public ReportCreator(LimitsChecker limitsChecker,
                         MealService mealService,
                         BodySizeRepoService bodySizeRepoService,
                         TrainingService trainingService,
                         HeadersCreator headersCreator,
                         ShortReportService shortReportService) {
        this.limitsChecker = limitsChecker;
        this.mealService = mealService;
        this.bodySizeRepoService = bodySizeRepoService;
        this.trainingService = trainingService;
        this.headersCreator = headersCreator;
        this.shortReportService = shortReportService;
    }

    //Zoptymalizować przez pobieranie lilitu bezpośrednio a nie całego użytkownika
    public FormReport createByDayAndUser (Day day, User user, boolean isLongReport){
        int sumOfKcal = mealService.getDailyDietByListMeal(day.getListMealsDB()).getSumOfKcal();
        String dateLastMeasureBody = bodySizeRepoService.getDateLastMeasureByUserId(user.getId())
                .map(String::valueOf)
                .orElse("Nie wykonano żadnego pomiaru ciała");
        DailyDiet dailyDietByListMeal = mealService.getDailyDietByListMeal(day.getListMealsDB());
        boolean isAchievedDrink = limitsChecker.checkIsAchievedDrink(
                user.getDailyLimits().getDrinkDemandPerDay(),
                day.getPortionsDrink());
        boolean isAchievedKcal = limitsChecker.checkIsAchievedKcal(
                user.getDailyLimits().getKcalDemandPerDay(),
                sumOfKcal);
        if (isLongReport){
            return new LongReport(
                    day.getId(),
                    day.getDate(),
                    user.getId(),
                    day.getPortionsDrink(),
                    day.getPortionsAlcohol(),
                    day.getPortionsSnack(),
                    user.getNick(),
                    dateLastMeasureBody,
                    isAchievedDrink,
                    isAchievedKcal,
                    dailyDietByListMeal,
                    trainingService.getTrainingsSummaryByTrainings(day.getListTrainingsDB()),
                    headersCreator.getHeadersByNotes(day.getListNotesDB()),
                    shortReportService.getShortReportsByDateAndUserId(day.getDate(), user.getId())
            );
        }
        return new Report(
                day.getId(),
                day.getDate(),
                user.getId(),
                day.getPortionsDrink(),
                day.getPortionsAlcohol(),
                day.getPortionsSnack(),
                user.getNick(),
                dateLastMeasureBody,
                isAchievedDrink,
                isAchievedKcal
        );
    }
}
