package com.CezaryZal.api.training;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "training")
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date_time")
    private LocalDateTime dateTimeOfExecution;

    @Column(name = "description")
    private String description;

    @Column(name = "time")
    private LocalTime elapsedTime;

    @Column(name = "burn_kcal")
    private int burnKcal;

    @Column(name = "day_id")
    private Long dayId;

    public Training() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateTimeOfExecution() {
        return dateTimeOfExecution;
    }

    public void setDateTimeOfExecution(LocalDateTime date) {
        this.dateTimeOfExecution = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalTime getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(LocalTime time) {
        this.elapsedTime = time;
    }

    public int getBurnKcal() {
        return burnKcal;
    }

    public void setBurnKcal(int burnKcal) {
        this.burnKcal = burnKcal;
    }

    public Long getDayId() {
        return dayId;
    }

    public void setDayId(Long dayId) {
        this.dayId = dayId;
    }

    @Override
    public String toString() {
        return "TrainingDB{" +
                "id=" + id +
                ", date=" + dateTimeOfExecution +
                ", description='" + description + '\'' +
                ", time=" + elapsedTime +
                ", burnKcal=" + burnKcal +
                ", dayId=" + dayId +
                '}';
    }
}
