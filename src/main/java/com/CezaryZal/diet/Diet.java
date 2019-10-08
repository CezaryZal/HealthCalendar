//package com.CezaryZal.diet;
//
//import javax.persistence.*;
//import java.time.LocalDate;
//
//@Entity
//@Table(name = "diet")
//public class Diet {
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
//    @Column(name = "type_meal")
//    private String typeMeal;
//
//    @Column(name = "meal_kcal")
//    private int mealKcal;
//
//    @Column(name = "meal_text")
//    private String mealText;
//
//
//    public Diet() {
//    }
//
//    public Diet(LocalDate date, String typeMeal, int mealKcal, String mealText) {
//        this.date = date;
//        this.typeMeal = typeMeal;
//        this.mealKcal = mealKcal;
//        this.mealText = mealText;
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
//    public String getTypeMeal() {
//        return typeMeal;
//    }
//
//    public void setTypeMeal(String typeMeal) {
//        this.typeMeal = typeMeal;
//    }
//
//    public int getMealKcal() {
//        return mealKcal;
//    }
//
//    public void setMealKcal(int mealKcal) {
//        this.mealKcal = mealKcal;
//    }
//
//    public String getMealText() {
//        return mealText;
//    }
//
//    public void setMealText(String mealText) {
//        this.mealText = mealText;
//    }
//
//    @Override
//    public String toString() {
//        return "Diet{" +
//                "id=" + id +
//                ", date=" + date +
//                ", typeMeal='" + typeMeal + '\'' +
//                ", mealKcal=" + mealKcal +
//                ", mealText='" + mealText + '\'' +
//                '}';
//    }
//}
//
//
