package com.CezaryZal.day;

import com.CezaryZal.bodySize.BodySizeService;
import com.CezaryZal.day.shortDay.ShortDay;
import com.CezaryZal.day.shortDay.ShortDayService;
import com.CezaryZal.meal.MealService;
import com.CezaryZal.meal.DailyDiet;
import com.CezaryZal.note.NoteService;
import com.CezaryZal.training.TrainingService;
import com.CezaryZal.user.UserDB;
import com.CezaryZal.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Transactional
@Service
public class DayService {

    private DayRepository dayR;
    private UserService userS;
    private BodySizeService bodySizeS;
    private MealService mealS;
    private TrainingService trainingS;
    private NoteService noteS;
    private ShortDayService shortDayS;


    //Można uzyskać wszystkie dane z jednego requestu i w service wszystko obrobić
    //Posiadając obecne endpointy możliwe jest stworzenie strony bieżaco doładowując dane
    @Autowired
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


    public DayDB findById(int id){
        DayDB dayDB = dayR.findById(id);

        return dayDB;
    }

    public Day getDayByDateAndUserId(String inputDate, int userId) {
        DayDB dayDB = dayR.findByDateAndUserId(LocalDate.parse(inputDate), userId);
        UserDB userDB = userS.getUserDBById(userId);
        DailyDiet dailyDiet = mealS.getDailyDiet(getDayIdByDateAndUserId(inputDate, userId));

        return new Day(dayDB.getId(),
                dayDB.getDate(),
                userId,
                userDB.getNick(),
                bodySizeS.getDateLastMeasureByUserId(userId),
                dayDB.getPortionsDrink(),
                checkIsAchievedDrink(userDB, dayDB),
                dayDB.getPortionsAlcohol(),
                dailyDiet,
                checkIsAchievedKcal(userDB, dailyDiet),
                dayDB.getPortionsSnack(),
                trainingS.getTrainingsByDay(getDayIdByDateAndUserId(inputDate, userId)),
                noteS.getHeadersByDay(getDayIdByDateAndUserId(inputDate, userId)),
                shortDayS.getShortDaysByDateAndUserId(inputDate, userId)
        );
    }

    public int getDayIdByDateAndUserId(String inputDate, int userId){
        int dayId = dayR.findDayIdByDateAndUserId(LocalDate.parse(inputDate), userId);

        return dayId;
    }

    public DayDB getDayDBByDateAndUserId(String inputDate, int userId){
        DayDB dayDB = dayR.findByDateAndUserId(LocalDate.parse(inputDate), userId);

        return dayDB;
    }

    public List<DayDB> getAll (){
        List<DayDB> listDayDb = dayR.getAll();

        return listDayDb;
    }

    public boolean addDay (DayDB dayDB){
        dayR.save(dayDB);
        shortDayS.addShortDay(createShortDayByDayDB(dayDB));

        return true;
    }

    public boolean updateDay (DayDB dayDB){
        dayR.update(dayDB);
        ShortDay shortDay = createShortDayByDayDB(dayDB);
        shortDay.setId(dayDB.getId());
        shortDayS.updateShortDay(shortDay);
        return true;
    }

    public String deleteDayById(int id){
        DayDB dayDB = dayR.findById(id);
        if(dayR.delete(dayDB)){
            return "delete record";
        }
        return "Day id not found";
    }

    public boolean checkIsAchievedDrink(UserDB userDB, DayDB dayDB){
        return userDB.getDailyLimits().getDrinkDemand()<=dayDB.getPortionsDrink() * 250;
    }

    public boolean checkIsAchievedKcal(UserDB userDB, DailyDiet dailyDiet){
        int kcalDemand = userDB.getDailyLimits().getKcalDemand();
        int sumOfKcal = dailyDiet.getSumOfKcal();
        return sumOfKcal>=kcalDemand-kcalDemand*0.05 && sumOfKcal<=kcalDemand+kcalDemand*0.05;
    }

    public ShortDay createShortDayByDayDB(DayDB dayDB){
        String inputDate = dayDB.getDate().toString();
        UserDB userDB = userS.getUserDBById(dayDB.getUserId());
        DailyDiet dailyDiet = mealS.getDailyDiet(getDayIdByDateAndUserId(inputDate, dayDB.getUserId()));

        return new ShortDay(
                dayDB.getUserId(),
                dayDB.getDate(),
                checkIsAchievedKcal(userDB, dailyDiet),
                checkIsAchievedDrink(userDB, dayDB),
                dayDB.getPortionsAlcohol()!=0,
                dayDB.getPortionsSnack()!=0
        );
    }

}
