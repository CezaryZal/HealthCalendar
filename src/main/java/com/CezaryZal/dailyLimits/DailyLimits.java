package com.CezaryZal.dailyLimits;

import com.CezaryZal.user.UserAllInf;

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

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private UserAllInf userAllInf;

    public DailyLimits() {
    }

    public DailyLimits(int kcalDemand, int drinkDemand, UserAllInf userAllInf) {
        this.kcalDemand = kcalDemand;
        this.drinkDemand = drinkDemand;
        this.userAllInf = userAllInf;
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

    public UserAllInf getUserAllInf() {
        return userAllInf;
    }

    public void setUserAllInf(UserAllInf userAllInf) {
        this.userAllInf = userAllInf;
    }

    @Override
    public String toString() {
        return "DailyLimits{" +
                "id=" + id +
                ", kcalDemand=" + kcalDemand +
                ", drinkDemand=" + drinkDemand +
                ", userAllInf=" + userAllInf +
                '}';
    }
}
