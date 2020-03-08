package com.CezaryZal.api.day.manager;

import com.CezaryZal.api.day.model.ObjectToSaveDay;
import com.CezaryZal.api.day.model.entity.Day;
import com.CezaryZal.api.report.shortened.model.entity.ShortReport;
import org.springframework.stereotype.Service;

@Service
public class DayCreator {

    Day createDayToUpdateByDayApiAndShortDay(
            Day currentDay,
            ObjectToSaveDay objectToSaveDay,
            ShortReport shortReport){

        return Day.builder()
                .id(currentDay.getId())
                .date(objectToSaveDay.getDate())
                .userId(objectToSaveDay.getUserId())
                .portionsDrink(objectToSaveDay.getPortionsDrink())
                .portionsAlcohol(objectToSaveDay.getPortionsAlcohol())
                .portionsSnack(objectToSaveDay.getPortionsSnack())
                .listMeal(currentDay.getListMealsDB())
                .listTrainings(currentDay.getListTrainingsDB())
                .listNotes(currentDay.getListNotesDB())
                .shortReport(shortReport)
                .build();

    }

    Day createDayByDayApi(ObjectToSaveDay day, ShortReport shortReport){
        return Day.builder()
                .date(day.getDate())
                .userId(day.getUserId())
                .portionsDrink(day.getPortionsDrink())
                .portionsAlcohol(day.getPortionsAlcohol())
                .portionsSnack(day.getPortionsSnack())
                .shortReport(shortReport)
                .build();
    }
}
