package com.CezaryZal.meal;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "meal")
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date_time")
    private LocalDateTime dateTimeOfEat;

    @Column(name = "type")
    private String type;

    @Column(name = "kcal")
    private int kcal;

    @Column(name = "description")
    private String description;

    @Column(name = "day_id")
    private Long dayId;

    public Meal() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateTimeOfEat() {
        return dateTimeOfEat;
    }

    public void setDateTimeOfEat(LocalDateTime dateTime) {
        this.dateTimeOfEat = dateTime;
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
                ", dateTime=" + dateTimeOfEat +
                ", type='" + type + '\'' +
                ", kcal=" + kcal +
                ", description='" + description + '\'' +
                ", dayId=" + dayId +
                '}';
    }
}


