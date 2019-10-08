//package com.CezaryZal.training;
//
//import javax.persistence.*;
//import java.time.LocalDate;
//
//@Entity
//@Table(name = "training")
//public class Training {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private int id;
//
//    @Column(name = "date")
//    private LocalDate date;
//
////    DATETIME
//
//    @Column(name = "training_text")
//    private String trainingText;
//
//    @Column(name = "training_time")
//    private int trainingTime;
//
//    @Column(name = "training_kcal")
//    private int trainingKcal;
//
//    @Column(name = "day_id")
//    private int dayId;
//
//    public Training() {
//    }
//
//    public Training(LocalDate date, String trainingText, int trainingTime, int trainingKcal, int dayId) {
//        this.date = date;
//        this.trainingText = trainingText;
//        this.trainingTime = trainingTime;
//        this.trainingKcal = trainingKcal;
//        this.dayId = dayId;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public LocalDate getDate() {
//        return date;
//    }
//
//    public void setDate(LocalDate date) {
//        this.date = date;
//    }
//
//    public String getTrainingText() {
//        return trainingText;
//    }
//
//    public void setTrainingText(String trainingText) {
//        this.trainingText = trainingText;
//    }
//
//    public int getTrainingTime() {
//        return trainingTime;
//    }
//
//    public void setTrainingTime(int trainingTime) {
//        this.trainingTime = trainingTime;
//    }
//
//    public int getTrainingKcal() {
//        return trainingKcal;
//    }
//
//    public void setTrainingKcal(int trainingKcal) {
//        this.trainingKcal = trainingKcal;
//    }
//
//    public int getDayId() {
//        return dayId;
//    }
//
//    public void setDayId(int dayId) {
//        this.dayId = dayId;
//    }
//
//    @Override
//    public String toString() {
//        return "Training{" +
//                "id=" + id +
//                ", date=" + date +
//                ", trainingText='" + trainingText + '\'' +
//                ", trainingTime=" + trainingTime +
//                ", trainingKcal=" + trainingKcal +
//                ", dayId=" + dayId +
//                '}';
//    }
//}
