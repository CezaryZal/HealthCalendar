package com.CezaryZal.api.day.manager.creator;

import com.CezaryZal.api.body.manager.BodySizeService;
import com.CezaryZal.api.day.entity.api.DayApiWithConnectedEntities;
import com.CezaryZal.api.day.entity.day.Day;
import com.CezaryZal.api.limits.manager.checker.LimitsChecker;
import com.CezaryZal.api.meal.entity.DailyDiet;
import com.CezaryZal.api.meal.manager.MealService;
import com.CezaryZal.api.note.manager.creator.HeadersCreator;
import com.CezaryZal.api.shortday.manager.ShortDayService;
import com.CezaryZal.api.training.manager.TrainingService;
import com.CezaryZal.api.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DayApiWithEntitiesCreator {

    private final LimitsChecker limitsChecker;
    private final MealService mealService;
    private final BodySizeService bodySizeService;
    private final TrainingService trainingService;
    private final HeadersCreator headersCreator;
    private final ShortDayService shortDayService;

    @Autowired
    public DayApiWithEntitiesCreator(LimitsChecker limitsChecker,
                                     MealService mealService,
                                     BodySizeService bodySizeService,
                                     TrainingService trainingService,
                                     HeadersCreator headersCreator,
                                     ShortDayService shortDayService) {
        this.limitsChecker = limitsChecker;
        this.mealService = mealService;
        this.bodySizeService = bodySizeService;
        this.trainingService = trainingService;
        this.headersCreator = headersCreator;
        this.shortDayService = shortDayService;
    }

    public DayApiWithConnectedEntities createByDayAndUser (Day day, User user){
        int sumOfKcal = mealService.getDailyDietByListMeal(day.getListMealsDB()).getSumOfKcal();
        LocalDate dateLastMeasureBody = bodySizeService.getDateLastMeasureByUserId(user.getId());
        DailyDiet dailyDietByListMeal = mealService.getDailyDietByListMeal(day.getListMealsDB());

        return new DayApiWithConnectedEntities(
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
                dailyDietByListMeal,
                limitsChecker.checkIsAchievedKcal(
                        user.getDailyLimits().getKcalDemandPerDay(),
                        sumOfKcal),
                trainingService.getTrainingsSummaryByTrainings(day.getListTrainingsDB()),
                headersCreator.getHeadersByNotes(day.getListNotesDB()),
                shortDayService.getShortDaysByDateAndUserId(day.getDate(), user.getId())
        );
    }
}
