package com.CezaryZal.dailyLimits;


import javax.persistence.*;

@Entity
@Table(name = "daily_limits")
public class DailyLimits {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "kcal_demand")
    private int kcalDemandPerDay;

    @Column(name = "drink_demand")
    private int drinkDemandPerDay;

    @Column(name = "user_id")
    private Long userId;

    public DailyLimits() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getKcalDemandPerDay() {
        return kcalDemandPerDay;
    }

    public void setKcalDemandPerDay(int kcalDemand) {
        this.kcalDemandPerDay = kcalDemand;
    }

    public int getDrinkDemandPerDay() {
        return drinkDemandPerDay;
    }

    public void setDrinkDemandPerDay(int drinkDemand) {
        this.drinkDemandPerDay = drinkDemand;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "DailyLimits{" +
                "id=" + id +
                ", kcalDemand=" + kcalDemandPerDay +
                ", drinkDemand=" + drinkDemandPerDay +
                ", userId=" + userId +
                '}';
    }
}
