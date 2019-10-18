package com.CezaryZal.day;

import com.CezaryZal.bodySize.BodySizeService;
import com.CezaryZal.dailyLimits.DailyLimitsService;
import com.CezaryZal.meal.MealService;
import com.CezaryZal.meal.diet.DailyDiet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Transactional
@Service
public class DayService {

    private DayRepository DRepository;
    private BodySizeService BSService;
    private DailyLimitsService DLService;
    private MealService MService;

    @Autowired
    public DayService(DayRepository DRepository, BodySizeService BSService, DailyLimitsService DLService, MealService MService) {
        this.DRepository = DRepository;
        this.BSService = BSService;
        this.DLService = DLService;
        this.MService = MService;
    }

    public DayDB findById(int id){
        DayDB dayDB = DRepository.findById(id);

        return dayDB;
    }

    public Day getDayByDateAndUserId(String inputDate, int userId, int dayId) {
        LocalDate localDate = LocalDate.parse(inputDate);

        DayDB dayDB = DRepository.findByDateAndUserId(localDate, userId);
        int drinkDemand = DLService.getLimitsByUserId(userId).getDrinkDemand();
        boolean isDrinkDemand = drinkDemand<=dayDB.getPortionsDrink() * 250;
        DailyDiet dailyDiet = MService.getDailyDiet(inputDate, dayId);
        int kcalDemand = DLService.getLimitsByUserId(userId).getKcalDemand();
        int sumKcal = dailyDiet.getSumKcal();
        boolean isKcalDemand = sumKcal>=kcalDemand-kcalDemand*0.05 && sumKcal<=kcalDemand+kcalDemand*0.05;

        Day day = new Day(dayDB.getId(),
                dayDB.getDate(),
                dayDB.getUserId(),
                BSService.getDateLastMeasureByUserId(userId),
                dayDB.getPortionsDrink(),
                isDrinkDemand,
                dayDB.getPortionsAlcohol(),
                dailyDiet,
                isKcalDemand,
                dayDB.getPortionsSnack());
        return day;
    }


    public DayDB getDayDBByDateAndUserId(String inputDate, int userId){
        LocalDate localDate = LocalDate.parse(inputDate);
        DayDB dayDB = DRepository.findByDateAndUserId(localDate, userId);

        return dayDB;
    }

    public List<DayDB> getAll (){
        List<DayDB> listDayDb = DRepository.getAll();

        return listDayDb;
    }

    public boolean addDay (DayDB dayDB){
        DRepository.save(dayDB);

        return true;
    }

    public boolean updateDay (DayDB dayDB){
        DRepository.update(dayDB);

        return true;
    }

    public String deleteDayById(int id){
        DayDB dayDB = DRepository.findById(id);
        if(DRepository.delete(dayDB)){
            return "delete record";
        }
        return "Day id not found";
    }

}
