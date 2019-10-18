//package com.CezaryZal.day.shortDay;
//
//import javax.persistence.*;
//import java.time.LocalDate;
//
//@Entity
//@Table(name = "short_day")
//public class ShortDay {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private int id;
//
//    @Column(name = "user_id")
//    private int userId;
//
//    @Column(name = "date")
//    private LocalDate date;
//
//    @Column(name = "is_limit_kcal")
//    private boolean isLimitKcal;
//
//    @Column(name = "is_limit_drink")
//    private boolean isLimitDrink;
//
//    @Column(name = "is_alcohol")
//    private boolean isAlcohol;
//
//    @Column(name = "is_snacks")
//    private boolean isSnacks;
//
//    public ShortDay() {
//    }
//
//    public ShortDay(int userId, LocalDate date, boolean isLimitKcal, boolean isLimitDrink, boolean isAlcohol, boolean isSnacks) {
//        this.userId = userId;
//        this.date = date;
//        this.isLimitKcal = isLimitKcal;
//        this.isLimitDrink = isLimitDrink;
//        this.isAlcohol = isAlcohol;
//        this.isSnacks = isSnacks;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public int getUserId() {
//        return userId;
//    }
//
//    public void setUserId(int userId) {
//        this.userId = userId;
//    }
//
//    public LocalDate getDate() {
//        return date;
//    }
//
//    public void setDate(LocalDate date) {
//        this.date = date;
//    }
//
//    public boolean isLimitKcal() {
//        return isLimitKcal;
//    }
//
//    public void setLimitKcal(boolean limitKcal) {
//        isLimitKcal = limitKcal;
//    }
//
//    public boolean isLimitDrink() {
//        return isLimitDrink;
//    }
//
//    public void setLimitDrink(boolean limitDrink) {
//        isLimitDrink = limitDrink;
//    }
//
//    public boolean isAlcohol() {
//        return isAlcohol;
//    }
//
//    public void setAlcohol(boolean alcohol) {
//        isAlcohol = alcohol;
//    }
//
//    public boolean isSnacks() {
//        return isSnacks;
//    }
//
//    public void setSnacks(boolean snacks) {
//        isSnacks = snacks;
//    }
//
//    @Override
//    public String toString() {
//        return "ShortDay{" +
//                "id=" + id +
//                ", userId=" + userId +
//                ", date=" + date +
//                ", isLimitKcal=" + isLimitKcal +
//                ", isLimitDrink=" + isLimitDrink +
//                ", isAlcohol=" + isAlcohol +
//                ", isSnacks=" + isSnacks +
//                '}';
//    }
//}
//
