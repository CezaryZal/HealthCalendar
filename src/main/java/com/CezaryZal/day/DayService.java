package com.CezaryZal.day;

import com.CezaryZal.bodySize.BodySizeService;
import com.CezaryZal.shortDay.ShortDay;
import com.CezaryZal.shortDay.ShortDayService;
import com.CezaryZal.meal.MealService;
import com.CezaryZal.meal.DailyDietDTO;
import com.CezaryZal.note.NoteService;
import com.CezaryZal.training.TrainingService;
import com.CezaryZal.user.User;
import com.CezaryZal.user.UserService;
import org.springframework.stereotype.Service;

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


    //Posiadając obecne endpointy możliwe jest stworzenie strony bieżaco doładowując dane
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
        return dayR.findById(id);
    }

    //Dodatkowa klasa DayDTOCreator
    public DayDTO getDayDTOByDateAndUserId(String inputDate, Long userId) {
        Day day = getDayByDateAndUserId(inputDate, userId);
        User user = userS.getUserById(userId);
        DailyDietDTO dailyDietDTO = mealS.getDailyDietDTOByDayId(day.getId());

        return new DayDTO(
                day.getId(),
                day.getDate(),
                userId,
                user.getNick(),
                bodySizeS.getDateLastMeasureByUserId(userId),
                day.getPortionsDrink(),
                checkIsAchievedDrink(user, day),
                day.getPortionsAlcohol(),
                dailyDietDTO,
                checkIsAchievedKcal(user, dailyDietDTO),
                day.getPortionsSnack(),
                trainingS.createAllTrainingsDTOByDay(day.getListTrainingsDB()),
                noteS.getHeadersByNotesDB(day.getListNotesDB()),
                shortDayS.getShortDaysByDateAndUserId(inputDate, userId)
        );
    }

    public int getDayIdByDateAndUserId(String inputDate, Long userId) {
        return dayR.findDayIdByDateAndUserId(LocalDate.parse(inputDate), userId);
    }

    public Day getDayByDateAndUserId(String inputDate, Long userId) {
        return dayR.findDayByDateAndUserId(LocalDate.parse(inputDate), userId);
    }

    public List<Day> getAll() {
        return dayR.getAll();
    }

    public boolean addDay(Day day) {
        dayR.save(day);
        // dodanie w servisie shortDay
        shortDayS.addShortDay(createShortDayByDay(day));

        return true;
    }

    public boolean updateDay(Day day) {
        dayR.update(day);
        ShortDay shortDay = createShortDayByDay(day);
        shortDay.setId(day.getId());
        shortDayS.updateShortDay(shortDay);
        return true;
    }

    public String deleteDayById(Long id) {
        Day day = dayR.findById(id);
        if (dayR.delete(day)) {
            return "delete record";
        }
        return "Day id not found";
    }

    int PORTION_OF_DRINK = 250;

    public boolean checkIsAchievedDrink(User user, Day day) {
        return user.getDailyLimits().getDrinkDemandPerDay() <= day.getPortionsDrink() * PORTION_OF_DRINK;
    }

    double LIMIT_OF_EAT_KCAL = 0.05; // 5%

    public boolean checkIsAchievedKcal(User user, DailyDietDTO dailyDietDTO) {
        int kcalDemand = user.getDailyLimits().getKcalDemandPerDay();
        int sumOfKcal = dailyDietDTO.getSumOfKcal();
        return sumOfKcal >= kcalDemand - kcalDemand * LIMIT_OF_EAT_KCAL && sumOfKcal <= kcalDemand + kcalDemand * LIMIT_OF_EAT_KCAL;
    }

    //Dodatkowa klasa serwisowa dla ShortDay
    public ShortDay createShortDayByDay(Day day) {
        User user = userS.getUserById(day.getUserId());
        DailyDietDTO dailyDietDTO = mealS.getDailyDietDTOByDayId(day.getId());

        return new ShortDay(
                day.getUserId(),
                day.getDate(),
                checkIsAchievedKcal(user, dailyDietDTO),
                checkIsAchievedDrink(user, day),
                day.getPortionsAlcohol() != 0,
                day.getPortionsSnack() != 0
        );
    }

}
