package com.CezaryZal.day;


import com.CezaryZal.meal.DailyDiet;
import com.CezaryZal.note.HeaderByDay;
import com.CezaryZal.training.AllTrainingsByDay;

import java.time.LocalDate;
import java.util.List;


public class Day {

    private int id;
    private LocalDate date;
    private int userId;
    private String nick;
    private LocalDate lastDateMeasureBody;
    private int portionsDrink;
    private boolean isAchievedDrink;
    private int portionsAlcohol;
    private DailyDiet dailyDiet;
    private boolean isAchievedKcal;
    private int portionsSnack;
    private AllTrainingsByDay trainings;
    private List<HeaderByDay> listHeaders;

    public Day(int id, LocalDate date, int userId, String nick, LocalDate lastDateMeasureBody, int portionsDrink,
               boolean isAchievedDrink, int portionsAlcohol, DailyDiet dailyDiet, boolean isAchievedKcal,
               int portionsSnack, AllTrainingsByDay trainings, List<HeaderByDay> listHeaders) {
        this.id = id;
        this.date = date;
        this.userId = userId;
        this.nick = nick;
        this.lastDateMeasureBody = lastDateMeasureBody;
        this.portionsDrink = portionsDrink;
        this.isAchievedDrink = isAchievedDrink;
        this.portionsAlcohol = portionsAlcohol;
        this.dailyDiet = dailyDiet;
        this.isAchievedKcal = isAchievedKcal;
        this.portionsSnack = portionsSnack;
        this.trainings = trainings;
        this.listHeaders = listHeaders;
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

    public String getNick() {
        return nick;
    }

    public LocalDate getLastDateMeasureBody() {
        return lastDateMeasureBody;
    }

    public int getPortionsDrink() {
        return portionsDrink;
    }

    public boolean isAchievedDrink() {
        return isAchievedDrink;
    }

    public int getPortionsAlcohol() {
        return portionsAlcohol;
    }

    public DailyDiet getDailyDiet() {
        return dailyDiet;
    }

    public boolean isAchievedKcal() {
        return isAchievedKcal;
    }

    public int getPortionsSnack() {
        return portionsSnack;
    }

    public AllTrainingsByDay getTrainings() {
        return trainings;
    }

    public List<HeaderByDay> getListHeaders() {
        return listHeaders;
    }

    @Override
    public String toString() {
        return "Day{" +
                "id=" + id +
                ", date=" + date +
                ", userId=" + userId +
                ", nick='" + nick + '\'' +
                ", lastDateMeasureBody=" + lastDateMeasureBody +
                ", portionsDrink=" + portionsDrink +
                ", isAchievedDrink=" + isAchievedDrink +
                ", portionsAlcohol=" + portionsAlcohol +
                ", dailyDiet=" + dailyDiet +
                ", isAchievedKcal=" + isAchievedKcal +
                ", portionsSnack=" + portionsSnack +
                ", trainings=" + trainings +
                ", listHeaders=" + listHeaders +
                '}';
    }
}
