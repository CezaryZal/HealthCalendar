//package com.CezaryZal.dailyLimits;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "daily_limits")
//public class DailyLimits {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private int id;
//
//    @Column(name = "limit_kcal")
//    private int limitKcal;
//
//    @Column(name = "limit_drink")
//    private int limitDrink;
//
//    public DailyLimits() {
//    }
//
//    public DailyLimits(int limitKcal, int limitDrink) {
//        this.limitKcal = limitKcal;
//        this.limitDrink = limitDrink;
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
//    public int getLimitKcal() {
//        return limitKcal;
//    }
//
//    public void setLimitKcal(int limitKcal) {
//        this.limitKcal = limitKcal;
//    }
//
//    public int getLimitDrink() {
//        return limitDrink;
//    }
//
//    public void setLimitDrink(int limitDrink) {
//        this.limitDrink = limitDrink;
//    }
//
//    @Override
//    public String toString() {
//        return "DailyLimits{" +
//                "id=" + id +
//                ", limitKcal=" + limitKcal +
//                ", limitDrink=" + limitDrink +
//                '}';
//    }
//}
