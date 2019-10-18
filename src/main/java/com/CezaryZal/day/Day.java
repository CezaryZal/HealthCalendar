package com.CezaryZal.day;


import com.CezaryZal.meal.diet.DailyDiet;

import java.time.LocalDate;


public class Day {

    private int id;
    private LocalDate date;
    private int userId;
    private LocalDate lastDateMeasureBody;
    private int portionsDrink;
    private boolean isMinDrink;
    private int portionsAlcohol;
    private DailyDiet dailyDiet;
    private int portionsSnack;

    public Day(int id, LocalDate date, int userId, LocalDate lastDateMeasureBody, int portionsDrink,
               boolean isMinDrink, int portionsAlcohol, DailyDiet dailyDiet, int portionsSnack) {
        this.id = id;
        this.date = date;
        this.userId = userId;
        this.lastDateMeasureBody = lastDateMeasureBody;
        this.portionsDrink = portionsDrink;
        this.isMinDrink = isMinDrink;
        this.portionsAlcohol = portionsAlcohol;
        this.dailyDiet = dailyDiet;
        this.portionsSnack = portionsSnack;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getUserId() {
        return userId;
    }

    public LocalDate getLastDateMeasureBody() {
        return lastDateMeasureBody;
    }

    public int getPortionsDrink() {
        return portionsDrink;
    }

    public boolean isMinDrink() {
        return isMinDrink;
    }

    public int getPortionsAlcohol() {
        return portionsAlcohol;
    }

    public DailyDiet getDailyDiet() {
        return dailyDiet;
    }

    public int getPortionsSnack() {
        return portionsSnack;
    }

    @Override
    public String toString() {
        return "Day{" +
                "id=" + id +
                ", date=" + date +
                ", userId=" + userId +
                ", lastDateMeasureBody=" + lastDateMeasureBody +
                ", portionsDrink=" + portionsDrink +
                ", isMinDrink=" + isMinDrink +
                ", portionsAlcohol=" + portionsAlcohol +
                ", dailyDiet=" + dailyDiet +
                ", portionsSnack=" + portionsSnack +
                '}';
    }
}
