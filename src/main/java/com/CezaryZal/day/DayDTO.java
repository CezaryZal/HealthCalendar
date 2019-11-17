package com.CezaryZal.day;


import com.CezaryZal.shortDay.ShortDay;
import com.CezaryZal.meal.DailyDietDTO;
import com.CezaryZal.note.Header;
import com.CezaryZal.training.TrainingsDTO;

import java.time.LocalDate;
import java.util.List;


public class DayDTO {

    private int id;
    private LocalDate date;
    private int userId;
    private String nick;
    private LocalDate lastDateMeasureBody;
    private int portionsDrink;
    private boolean isAchievedDrink;
    private int portionsAlcohol;
    private DailyDietDTO dailyDietDTO;
    private boolean isAchievedKcal;
    private int portionsSnack;
    private TrainingsDTO trainings;
    private List<Header> listHeaders;
    private List<ShortDay> listShortDays;

    public DayDTO(int id, LocalDate date, int userId, String nick, LocalDate lastDateMeasureBody, int portionsDrink,
                  boolean isAchievedDrink, int portionsAlcohol, DailyDietDTO dailyDietDTO, boolean isAchievedKcal,
                  int portionsSnack, TrainingsDTO trainings, List<Header> listHeaders, List<ShortDay> listShortDays) {
        this.id = id;
        this.date = date;
        this.userId = userId;
        this.nick = nick;
        this.lastDateMeasureBody = lastDateMeasureBody;
        this.portionsDrink = portionsDrink;
        this.isAchievedDrink = isAchievedDrink;
        this.portionsAlcohol = portionsAlcohol;
        this.dailyDietDTO = dailyDietDTO;
        this.isAchievedKcal = isAchievedKcal;
        this.portionsSnack = portionsSnack;
        this.trainings = trainings;
        this.listHeaders = listHeaders;
        this.listShortDays = listShortDays;
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

    public DailyDietDTO getDailyDietDTO() {
        return dailyDietDTO;
    }

    public boolean isAchievedKcal() {
        return isAchievedKcal;
    }

    public int getPortionsSnack() {
        return portionsSnack;
    }

    public TrainingsDTO getTrainings() {
        return trainings;
    }

    public List<Header> getListHeaders() {
        return listHeaders;
    }

    public List<ShortDay> getListShortDays() {
        return listShortDays;
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
                ", dailyDiet=" + dailyDietDTO +
                ", isAchievedKcal=" + isAchievedKcal +
                ", portionsSnack=" + portionsSnack +
                ", trainings=" + trainings +
                ", listHeaders=" + listHeaders +
                ", listShortDays=" + listShortDays +
                '}';
    }
}
