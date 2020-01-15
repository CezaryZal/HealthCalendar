package com.CezaryZal.api.shortday;

import javax.persistence.*;
import java.time.LocalDate;

//Mógłbym otrzymać obiekt na podstawie encji Day, ale w celu wyższej wydajności (m.in.N+1)
//stworzyłem oddzielną encje ShortDay
@Entity
@Table(name = "short_day")
public class ShortDay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

//    @JsonDeserialize(using = LocalDateDeserializer.class)
//    @JsonSerialize(using = LocalDateSerializer.class)
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

    public ShortDay(Long userId, LocalDate date, boolean isAchievedKcal, boolean isAchievedDrink,
                    boolean isAlcohol, boolean isSnacks) {
        this.userId = userId;
        this.date = date;
        this.isAchievedKcal = isAchievedKcal;
        this.isAchievedDrink = isAchievedDrink;
        this.isAlcohol = isAlcohol;
        this.isSnacks = isSnacks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
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

