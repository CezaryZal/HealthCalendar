package com.CezaryZal.api.day;

import com.CezaryZal.api.body.manager.BodySizeService;
import com.CezaryZal.api.shortday.ShortDay;
import com.CezaryZal.api.shortday.ShortDayService;
import com.CezaryZal.api.meal.manager.MealService;
import com.CezaryZal.api.meal.entity.DailyDiet;
import com.CezaryZal.api.note.manager.NoteService;
import com.CezaryZal.api.training.TrainingService;
import com.CezaryZal.api.user.entity.User;
import com.CezaryZal.api.user.manager.UserService;
import com.CezaryZal.exceptions.not.found.DayNotFoundException;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.time.LocalDate;
import java.util.List;

@Service
public class DayService {
    //zastosowanie polimorfizm (interface)
    private DayRepository dayR;
    private UserService userS;
    private BodySizeService bodySizeS;
    private MealService mealS;
    private TrainingService trainingS;
    private NoteService noteS;
    private ShortDayService shortDayS;


    public DayService(DayRepository dayR, UserService userS, BodySizeService bodySizeS, MealService mealS,
                      TrainingService trainingS, NoteService noteS, ShortDayService shortDayS) {
        this.dayR = dayR;
        this.userS = userS;
        this.bodySizeS = bodySizeS;
        this.mealS = mealS;
        this.trainingS = trainingS;
        this.noteS = noteS;
        this.shortDayS = shortDayS;
    }

    public Day getDayById(Long id) {
        return dayR.findById(id)
                .orElseThrow(() -> new DayNotFoundException("Day not found by id"));
    }

    //Dodatkowa klasa DayDTOCreator
    public DayDTO getDayDTOByDateAndUserId(String inputDate, Long userId) throws AccountNotFoundException {
        Day day = getDayByDateAndUserId(inputDate, userId);
        User user = userS.getUserById(userId);
        DailyDiet dailyDiet = mealS.getDailyDietDTOByDayId(day.getId());

        return new DayDTO(
                day.getId(),
                day.getDate(),
                userId,
                user.getNick(),
                bodySizeS.getDateLastMeasureByUserId(userId),
                day.getPortionsDrink(),
                checkIsAchievedDrink(user, day),
                day.getPortionsAlcohol(),
                dailyDiet,
                checkIsAchievedKcal(user, dailyDiet),
                day.getPortionsSnack(),
                trainingS.createAllTrainingsDTOByDay(day.getListTrainingsDB()),
                noteS.getHeadersByDay(day.getId()),
                shortDayS.getShortDaysByDateAndUserId(inputDate, userId)
        );
    }

    public Long getDayIdByDateAndUserId(String inputDate, Long userId) {
        return dayR.getDayIdByDateAndUserId(LocalDate.parse(inputDate), userId)
                .orElseThrow(() -> new DayNotFoundException("Id day not found by date and user id"));
    }

    public Day getDayByDateAndUserId(String inputDate, Long userId) {
        return dayR.findDayByDateAndUserId(LocalDate.parse(inputDate), userId)
                .orElseThrow(() -> new DayNotFoundException("Day not found by date and user id"));
    }

    public List<Day> getAll() {
        return (List<Day>) dayR.findAll();
    }

    public String addDay(Day day) throws AccountNotFoundException {
        dayR.save(day);
        shortDayS.addShortDay(createShortDayByDay(day));

        return "Dzień z aktualną datą został dodany do bazy danych";
    }

    public String updateDay(Day day) throws AccountNotFoundException {
        dayR.save(day);
        ShortDay shortDay = createShortDayByDay(day);
        shortDay.setId(day.getId());
        shortDayS.updateShortDay(shortDay);
        return "Wskazany dzień został aktualizowany wraz ze skrótem";
    }

    public String deleteDayById(Long id) {
        Day day = getDayById(id);
        shortDayS.deleteShortDayById(day.getShortDay().getId());
        dayR.deleteById(id);

        return "Dzień o podanym id został usunięty wraz ze skrótem dnia";
    }

    int PORTION_OF_DRINK = 250;

    public boolean checkIsAchievedDrink(User user, Day day) {
        return user.getDailyLimits().getDrinkDemandPerDay() <= day.getPortionsDrink() * PORTION_OF_DRINK;
    }

    double LIMIT_OF_EAT_KCAL = 0.05; // 5%

    public boolean checkIsAchievedKcal(User user, DailyDiet dailyDiet) {
        int kcalDemand = user.getDailyLimits().getKcalDemandPerDay();
        int sumOfKcal = dailyDiet.getSumOfKcal();
        return sumOfKcal >= kcalDemand - kcalDemand * LIMIT_OF_EAT_KCAL && sumOfKcal <= kcalDemand + kcalDemand * LIMIT_OF_EAT_KCAL;
    }

    //Dodatkowa klasa serwisowa dla ShortDay
    public ShortDay createShortDayByDay(Day day) throws AccountNotFoundException {
        User user = userS.getUserById(day.getUserId());
        DailyDiet dailyDiet = mealS.getDailyDietDTOByDayId(day.getId());

        return new ShortDay(
                day.getUserId(),
                day.getDate(),
                checkIsAchievedKcal(user, dailyDiet),
                checkIsAchievedDrink(user, day),
                day.getPortionsAlcohol() != 0,
                day.getPortionsSnack() != 0
        );
    }

}
