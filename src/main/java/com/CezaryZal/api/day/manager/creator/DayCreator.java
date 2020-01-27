package com.CezaryZal.api.day.manager.creator;

import com.CezaryZal.api.day.model.ObjectToSaveDay;
import com.CezaryZal.api.day.model.entity.Day;
import com.CezaryZal.api.report.shortened.model.entity.ShortReport;
import org.springframework.stereotype.Service;

@Service
public class DayCreator {

    public Day createByDayApiAndShortDay(ObjectToSaveDay day, ShortReport shortReport){
        return Day.Builder.builder()
                .id(day.getId())
                .date(day.getDate())
                .userId(day.getUserId())
                .portionsDrink(day.getPortionsDrink())
                .portionsAlcohol(day.getPortionsAlcohol())
                .portionsSnack(day.getPortionsSnack())
                .shortReport(shortReport)
                .build();
    }
}
