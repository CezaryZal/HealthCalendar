package com.CezaryZal.api.day.manager;

import com.CezaryZal.api.body.manager.BodySizeService;
import com.CezaryZal.api.day.DayRepository;
import com.CezaryZal.api.day.entity.api.DayApi;
import com.CezaryZal.api.day.entity.day.Day;
import com.CezaryZal.api.day.entity.api.DayApiWithConnectedEntities;
import com.CezaryZal.api.day.manager.repo.DayRepoService;
import com.CezaryZal.api.limits.manager.checker.LimitsChecker;
import com.CezaryZal.api.meal.manager.MealService;
import com.CezaryZal.api.note.manager.NoteService;
import com.CezaryZal.api.shortday.ShortDayService;
import com.CezaryZal.api.training.manager.TrainingService;
import com.CezaryZal.api.user.entity.User;
import com.CezaryZal.api.user.manager.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DayApiService extends DayRepoService {

    private final UserService userService;
    private final MealService mealService;
    private final BodySizeService bodySizeService;
    private final TrainingService trainingService;
    private final NoteService noteService;
    private final ShortDayService shortDayService;
    private final LimitsChecker limitsChecker;


    public DayApiService(DayRepository dayRepository, UserService userService, MealService mealService,
                         BodySizeService bodySizeService, TrainingService trainingService, NoteService noteService,
                         ShortDayService shortDayService, LimitsChecker limitsChecker) {
        super(dayRepository);
        this.userService = userService;
        this.mealService = mealService;
        this.bodySizeService = bodySizeService;
        this.trainingService = trainingService;
        this.noteService = noteService;
        this.shortDayService = shortDayService;
        this.limitsChecker = limitsChecker;
    }

    public DayApi getDayApiByDateAndUserId(String inputDate, Long userId){
        Day day = getDayByDateAndUserId(LocalDate.parse(inputDate), userId);
        User user = userService.getUserById(userId);
        int sumOfKcal = mealService.getDailyDietByListMeal(day.getListMealsDB())
                .getSumOfKcal();

        return new DayApi(
                day.getId(),
                day.getDate(),
                userId,
                day.getPortionsDrink(),
                day.getPortionsAlcohol(),
                day.getPortionsSnack(),
                user.getNick(),
                bodySizeService.getDateLastMeasureByUserId(userId),
                limitsChecker.checkIsAchievedDrink(user.getDailyLimits().getDrinkDemandPerDay(), day.getPortionsDrink()),
                limitsChecker.checkIsAchievedKcal(user.getDailyLimits().getKcalDemandPerDay(), sumOfKcal)
        );
    }

    public DayApiWithConnectedEntities getDayApiWithEntitiesByDateAndUserId(String inputDate, Long userId){
        Day day = getDayByDateAndUserId(LocalDate.parse(inputDate), userId);
        User user = userService.getUserById(userId);
        int sumOfKcal = mealService.getDailyDietByDayId(day.getId())
                .getSumOfKcal();

        return new DayApiWithConnectedEntities(
                day.getId(),
                day.getDate(),
                userId,
                day.getPortionsDrink(),
                day.getPortionsAlcohol(),
                day.getPortionsSnack(),
                user.getNick(),
                bodySizeService.getDateLastMeasureByUserId(userId),
                limitsChecker.checkIsAchievedDrink(user.getDailyLimits().getDrinkDemandPerDay(), day.getPortionsDrink()), //sprawdzic wydajnosciowo
                mealService.getDailyDietByDayId(day.getId()),
                limitsChecker.checkIsAchievedKcal(user.getDailyLimits().getKcalDemandPerDay(), sumOfKcal), //sprawdzic wydajnosciowo
                trainingService.getTrainingsSummaryByDayId(day.getId()),
                noteService.getHeadersByDay(day.getId()),
                shortDayService.getShortDaysByDateAndUserId(inputDate, userId)
        );
    }
}
