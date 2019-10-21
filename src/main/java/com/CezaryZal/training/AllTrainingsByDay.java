package com.CezaryZal.training;


import java.time.LocalTime;
import java.util.List;

public class AllTrainingsByDay {

    private List<TrainingDB> listTrainings;
    private int sumOfBurnKcal;
    private LocalTime sumOfTimes;

    public AllTrainingsByDay(List<TrainingDB> listTrainings, int sumOfBurnKcal, LocalTime sumOfTimes) {
        this.listTrainings = listTrainings;
        this.sumOfBurnKcal = sumOfBurnKcal;
        this.sumOfTimes = sumOfTimes;
    }

    public List<TrainingDB> getListTrainings() {
        return listTrainings;
    }

    public int getSumOfBurnKcal() {
        return sumOfBurnKcal;
    }

    public LocalTime getSumOfTimes() {
        return sumOfTimes;
    }

    @Override
    public String toString() {
        return "AllTrainingsByDay{" +
                "listTrainings=" + listTrainings +
                ", sumOfBurnKcal=" + sumOfBurnKcal +
                ", sumOfTimes=" + sumOfTimes +
                '}';
    }
}
