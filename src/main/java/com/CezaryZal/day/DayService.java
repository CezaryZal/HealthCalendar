package com.CezaryZal.day;

import com.CezaryZal.bodySize.BodySizeService;
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


    //Można uzyskać wszystkie dane z jednego requestu i w service wszystko obrobić
    //Po siadając obecne endpointy możliwe jest stworzenie strony bieżaco doładowując dane
    @Autowired
    public DayService(DayRepository dayR, UserService userS, BodySizeService bodySizeS, MealService mealS,
                      TrainingService trainingS, NoteService noteS) {
        this.dayR = dayR;
        this.userS = userS;
        this.bodySizeS = bodySizeS;
        this.mealS = mealS;
        this.trainingS = trainingS;
        this.noteS = noteS;
    }

    public DayDB findById(int id){
        DayDB dayDB = dayR.findById(id);

        return dayDB;
    }

    public Day getDayByDateAndUserId(String inputDate, int userId) {
        DayDB dayDB = dayR.findByDateAndUserId(LocalDate.parse(inputDate), userId);
        UserDB userDB = userS.getUserDBById(userId);
        boolean isDrinkDemand = userDB.getDailyLimits().getDrinkDemand()<=dayDB.getPortionsDrink() * 250;
        DailyDiet dailyDiet = mealS.getDailyDiet(getDayIdByDateAndUserId(inputDate, userId));
        int kcalDemand = userDB.getDailyLimits().getKcalDemand();
        int sumOfKcal = dailyDiet.getSumOfKcal();
        boolean isKcalDemand = sumOfKcal>=kcalDemand-kcalDemand*0.05 && sumOfKcal<=kcalDemand+kcalDemand*0.05;

        return new Day(dayDB.getId(),
                dayDB.getDate(),
                userId,
                userDB.getNick(),
                bodySizeS.getDateLastMeasureByUserId(userId),
                dayDB.getPortionsDrink(),
                isDrinkDemand,
                dayDB.getPortionsAlcohol(),
                dailyDiet,
                isKcalDemand,
                dayDB.getPortionsSnack(),
                trainingS.getTrainingsByDay(getDayIdByDateAndUserId(inputDate, userId)),
                noteS.getHeadersByDay(getDayIdByDateAndUserId(inputDate, userId)));
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

        return true;
    }

    public boolean updateDay (DayDB dayDB){
        dayR.update(dayDB);

        return true;
    }

    public String deleteDayById(int id){
        DayDB dayDB = dayR.findById(id);
        if(dayR.delete(dayDB)){
            return "delete record";
        }
        return "Day id not found";
    }

}
