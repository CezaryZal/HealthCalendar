package com.CezaryZal.api.meal.entity;

import java.util.List;

public class DailyDietDTO {

    private List<Meal> listMeals;
    private int sumOfKcal;

    public DailyDietDTO(List<Meal> listMeals, int sumOfKcal) {
        this.listMeals = listMeals;
        this.sumOfKcal = sumOfKcal;
    }

    public List<Meal> getListMeals() {
        return listMeals;
    }

    public int getSumOfKcal() {
        return sumOfKcal;
    }

    @Override
    public String toString() {
        return "DailyDiet{" +
                "listMeals=" + listMeals +
                ", sumOfKcal=" + sumOfKcal +
                '}';
    }
}
