package com.CezaryZal.drinkLiquids;

import javax.persistence.*;

@Entity
@Table(name = "drink_liquids")
public class DrinkLiquids {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "portions")
    private int portions;

    @Column(name = "amount")
    private int amount;

    @Column(name = "alcohol")
    private boolean alcohol;

    public DrinkLiquids() {
    }

    public DrinkLiquids(int portions, int amount, boolean alcohol) {
        this.portions = portions;
        this.amount = amount;
        this.alcohol = alcohol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPortions() {
        return portions;
    }

    public void setPortions(int portions) {
        this.portions = portions;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isAlcohol() {
        return alcohol;
    }

    public void setAlcohol(boolean alcohol) {
        this.alcohol = alcohol;
    }

    @Override
    public String toString() {
        return "DrinkLiquids{" +
                "id=" + id +
                ", portions=" + portions +
                ", amount=" + amount +
                ", alcohol=" + alcohol +
                '}';
    }
}
