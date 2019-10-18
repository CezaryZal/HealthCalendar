package com.CezaryZal.meal.diet;

import com.CezaryZal.meal.MealDB;

import java.util.List;

public class DailyDiet {

    private List<MealDB> listMealDBS;
    private int sumKcal;

    public DailyDiet(List<MealDB> listMealDBS, int sumKcal) {
        this.listMealDBS = listMealDBS;
        this.sumKcal = sumKcal;
    }

    public List<MealDB> getListMealDBS() {
        return listMealDBS;
    }

    public int getSumKcal() {
        return sumKcal;
    }

    @Override
    public String toString() {
        return "DailyDiet{" +
                "listMeals=" + listMealDBS +
                ", sumKcal=" + sumKcal +
                '}';
    }
}
