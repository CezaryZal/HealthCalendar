package com.CezaryZal.api.day;


import com.CezaryZal.api.shortday.ShortDay;
import com.CezaryZal.api.meal.DailyDietDTO;
import com.CezaryZal.api.note.Header;
import com.CezaryZal.api.training.TrainingsDTO;

import java.time.LocalDate;
import java.util.List;


public class DayDTO {

    private Long id;
    private LocalDate date;
    private Long userId;
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

    public DayDTO(Long id, LocalDate date, Long userId, String nick, LocalDate lastDateMeasureBody, int portionsDrink,
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

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public Long getUserId() {
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
