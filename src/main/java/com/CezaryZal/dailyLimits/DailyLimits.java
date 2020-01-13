package com.CezaryZal.dailyLimits;


import javax.persistence.*;

@Entity
@Table(name = "daily_limits")
public class DailyLimits {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "kcal_demand")
    private int kcalDemand;

    @Column(name = "drink_demand")
    private int drinkDemand;

    @Column(name = "user_id")
    private int userId;

    public DailyLimits() {
    }

    public DailyLimits(int kcalDemand, int drinkDemand, int userId) {
        this.kcalDemand = kcalDemand;
        this.drinkDemand = drinkDemand;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKcalDemand() {
        return kcalDemand;
    }

    public void setKcalDemand(int kcalDemand) {
        this.kcalDemand = kcalDemand;
    }

    public int getDrinkDemand() {
        return drinkDemand;
    }

    public void setDrinkDemand(int drinkDemand) {
        this.drinkDemand = drinkDemand;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "DailyLimits{" +
                "id=" + id +
                ", kcalDemand=" + kcalDemand +
                ", drinkDemand=" + drinkDemand +
                ", userId=" + userId +
                '}';
    }
}
