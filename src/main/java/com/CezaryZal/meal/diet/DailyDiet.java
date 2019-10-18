package com.CezaryZal.meal.diet;

import com.CezaryZal.meal.Meal;

import java.util.List;

public class DailyDiet {

    private List<Meal> listMeals;
    private int sumKcal;

    public DailyDiet(List<Meal> listMeals, int sumKcal) {
        this.listMeals = listMeals;
        this.sumKcal = sumKcal;
    }

    public List<Meal> getListMeals() {
        return listMeals;
    }

    public int getSumKcal() {
        return sumKcal;
    }

    @Override
    public String toString() {
        return "DailyDiet{" +
                "listMeals=" + listMeals +
                ", sumKcal=" + sumKcal +
                '}';
    }
}
