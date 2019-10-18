package com.CezaryZal.meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Transactional
@Service
public class MealService {

    private MealRepository MRepository;

    @Autowired
    public MealService(MealRepository MRepository) {
        this.MRepository = MRepository;
    }

    public Meal findById (int id){
        Meal meal = MRepository.findById(id);

        return meal;
    }

    public List<Meal> getListByDateAndDayId (String  inputDate, int dayId){
        LocalDate localDate = LocalDate.parse(inputDate);
        List<Meal> listMeals = MRepository.findByDateAndDayId(localDate, dayId);

        return listMeals;
    }

    public List<Meal> getAll (){
        List<Meal> listMeal = MRepository.getAll();

        return listMeal;
    }

    public boolean addMeal (Meal meal){
        MRepository.save(meal);

        return true;
    }

    public boolean updateMeal (Meal meal){
        MRepository.update(meal);

        return true;
    }

    public String deleteMealById (int id){
        Meal meal = MRepository.findById(id);
        if(MRepository.detele(meal)){
            return "delete record";
        }
        return "Diet id not found";
    }

}
