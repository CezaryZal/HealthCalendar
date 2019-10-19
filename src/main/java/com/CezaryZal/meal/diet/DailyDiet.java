package com.CezaryZal.meal.diet;

import com.CezaryZal.meal.MealDB;

import java.util.List;

public class DailyDiet {

    private List<MealDB> listMealDBS;
    private int sumOfKcal;

    public DailyDiet(List<MealDB> listMealDBS, int sumOfKcal) {
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
