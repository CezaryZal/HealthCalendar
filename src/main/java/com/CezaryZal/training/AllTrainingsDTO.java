package com.CezaryZal.training;


import java.time.LocalTime;
import java.util.List;

public class AllTrainingsDTO {

    private List<Training> listTrainings;
    private int sumOfBurnKcal;
    private LocalTime sumOfTimes;

    public AllTrainingsDTO(List<Training> listTrainings, int sumOfBurnKcal, LocalTime sumOfTimes) {
        this.listTrainings = listTrainings;
        this.sumOfBurnKcal = sumOfBurnKcal;
        this.sumOfTimes = sumOfTimes;
    }

    public List<Training> getListTrainings() {
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
