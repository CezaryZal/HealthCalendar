package com.CezaryZal.meal;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "meal")
public class MealDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @Column(name = "type")
    private String type;

    @Column(name = "kcal")
    private int kcal;

    @Column(name = "description")
    private String description;

    @Column(name = "day_id")
    private Long dayId;

    public MealDB() {
    }

    public MealDB(LocalDateTime dateTime, String type, int kcal, String description, Long dayId) {
        this.dateTime = dateTime;
        this.type = type;
        this.kcal = kcal;
        this.description = description;
        this.dayId = dayId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getDayId() {
        return dayId;
    }

    public void setDayId(Long dayId) {
        this.dayId = dayId;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", type='" + type + '\'' +
                ", kcal=" + kcal +
                ", description='" + description + '\'' +
                ", dayId=" + dayId +
                '}';
    }
}


