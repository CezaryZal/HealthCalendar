package com.CezaryZal.api.day.manager;

import com.CezaryZal.api.day.model.ObjectToSaveDay;
import com.CezaryZal.api.day.model.entity.Day;
import com.CezaryZal.api.report.shortened.model.entity.ShortReport;
import org.springframework.stereotype.Service;

@Service
public class DayCreator {

    Day createDayToUpdateByDayApiAndShortDay(ObjectToSaveDay day, ShortReport shortReport, Long dayId){
        return mappingDtoToDayBuilder(day, shortReport)
                .id(dayId)
                .build();
    }

    Day createDayByDayApi(ObjectToSaveDay day, ShortReport shortReport){
        return mappingDtoToDayBuilder(day, shortReport).build();
    }

    private Day.Builder mappingDtoToDayBuilder(ObjectToSaveDay day, ShortReport shortReport){
        return Day.builder()
                .date(day.getDate())
                .userId(day.getUserId())
                .portionsDrink(day.getPortionsDrink())
                .portionsAlcohol(day.getPortionsAlcohol())
                .portionsSnack(day.getPortionsSnack())
                .shortReport(shortReport);
    }
}
