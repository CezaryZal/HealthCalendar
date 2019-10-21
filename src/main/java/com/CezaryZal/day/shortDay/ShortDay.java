package com.CezaryZal.day.shortDay;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "short_day")
public class ShortDay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "is_achieved_kcal")
    private boolean isAchievedKcal;

    @Column(name = "is_achieved_drink")
    private boolean isAchievedDrink;

    @Column(name = "is_alcohol")
    private boolean isAlcohol;

    @Column(name = "is_snacks")
    private boolean isSnacks;

    public ShortDay() {
    }

    public ShortDay(int userId, LocalDate date, boolean isAchievedKcal, boolean isAchievedDrink,
                    boolean isAlcohol, boolean isSnacks) {
        this.userId = userId;
        this.date = date;
        this.isAchievedKcal = isAchievedKcal;
        this.isAchievedDrink = isAchievedDrink;
        this.isAlcohol = isAlcohol;
        this.isSnacks = isSnacks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isAchievedKcal() {
        return isAchievedKcal;
    }

    public void setAchievedKcal(boolean achievedKcal) {
        isAchievedKcal = achievedKcal;
    }

    public boolean isAchievedDrink() {
        return isAchievedDrink;
    }

    public void setAchievedDrink(boolean achievedDrink) {
        isAchievedDrink = achievedDrink;
    }

    public boolean isAlcohol() {
        return isAlcohol;
    }

    public void setAlcohol(boolean alcohol) {
        isAlcohol = alcohol;
    }

    public boolean isSnacks() {
        return isSnacks;
    }

    public void setSnacks(boolean snacks) {
        isSnacks = snacks;
    }

    @Override
    public String toString() {
        return "ShortDay{" +
                "id=" + id +
                ", userId=" + userId +
                ", date=" + date +
                ", isAchievedKcal=" + isAchievedKcal +
                ", isAchievedDrink=" + isAchievedDrink +
                ", isAlcohol=" + isAlcohol +
                ", isSnacks=" + isSnacks +
                '}';
    }
}

