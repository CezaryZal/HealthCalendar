package com.CezaryZal.meal;


import java.util.List;

public class DailyDietDTO {

    private List<MealDB> listMealDBS;
    private int sumOfKcal;

    public DailyDietDTO(List<MealDB> listMealDBS, int sumOfKcal) {
        this.listMealDBS = listMealDBS;
        this.sumOfKcal = sumOfKcal;
    }

    public List<MealDB> getListMealDBS() {
        return listMealDBS;
    }

    public int getSumOfKcal() {
        return sumOfKcal;
    }

    @Override
    public String toString() {
        return "DailyDiet{" +
                "listMeals=" + listMealDBS +
                ", sumOfKcal=" + sumOfKcal +
                '}';
    }
}