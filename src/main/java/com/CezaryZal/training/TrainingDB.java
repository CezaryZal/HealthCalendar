package com.CezaryZal.training;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAmount;

@Entity
@Table(name = "training")
public class TrainingDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "date_time")
    private LocalDateTime date;

    @Column(name = "description")
    private String description;

    @Column(name = "time")
    private LocalTime time;

    @Column(name = "burn_kcal")
    private int burnKcal;

    @Column(name = "day_id")
    private int dayId;

    public TrainingDB() {
    }

    public TrainingDB(LocalDateTime date, String description, LocalTime time, int burnKcal, int dayId) {
        this.date = date;
        this.description = description;
        this.time = time;
        this.burnKcal = burnKcal;
        this.dayId = dayId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public int getBurnKcal() {
        return burnKcal;
    }

    public void setBurnKcal(int burnKcal) {
        this.burnKcal = burnKcal;
    }

    public int getDayId() {
        return dayId;
    }

    public void setDayId(int dayId) {
        this.dayId = dayId;
    }

    @Override
    public String toString() {
        return "TrainingDB{" +
                "id=" + id +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", time=" + time +
                ", burnKcal=" + burnKcal +
                ", dayId=" + dayId +
                '}';
    }
}
