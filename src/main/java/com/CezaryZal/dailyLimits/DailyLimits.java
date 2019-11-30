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
    private int kcalDemand;

    @Column(name = "drink_demand")
    private int drinkDemand;

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
                ", kcalDemand=" + kcalDemand +
                ", drinkDemand=" + drinkDemand +
                ", userId=" + userId +
                '}';
    }
}
