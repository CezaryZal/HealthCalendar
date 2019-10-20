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
    private boolean isDrinkDemand;
    private int portionsAlcohol;
    private DailyDiet dailyDiet;
    private boolean isKcalDemand;
    private int portionsSnack;
    private AllTrainingsByDay trainings;
    private List<HeaderByDay> listHeaders;

    public Day(int id, LocalDate date, int userId, String nick, LocalDate lastDateMeasureBody, int portionsDrink,
               boolean isDrinkDemand, int portionsAlcohol, DailyDiet dailyDiet, boolean isKcalDemand,
               int portionsSnack, AllTrainingsByDay trainings, List<HeaderByDay> listHeaders) {
        this.id = id;
        this.date = date;
        this.userId = userId;
        this.nick = nick;
        this.lastDateMeasureBody = lastDateMeasureBody;
        this.portionsDrink = portionsDrink;
        this.isDrinkDemand = isDrinkDemand;
        this.portionsAlcohol = portionsAlcohol;
        this.dailyDiet = dailyDiet;
        this.isKcalDemand = isKcalDemand;
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

    public boolean isDrinkDemand() {
        return isDrinkDemand;
    }

    public int getPortionsAlcohol() {
        return portionsAlcohol;
    }

    public DailyDiet getDailyDiet() {
        return dailyDiet;
    }

    public boolean isKcalDemand() {
        return isKcalDemand;
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
                ", isDrinkDemand=" + isDrinkDemand +
                ", portionsAlcohol=" + portionsAlcohol +
                ", dailyDiet=" + dailyDiet +
                ", isKcalDemand=" + isKcalDemand +
                ", portionsSnack=" + portionsSnack +
                ", trainings=" + trainings +
                ", listHeaders=" + listHeaders +
                '}';
    }
}
