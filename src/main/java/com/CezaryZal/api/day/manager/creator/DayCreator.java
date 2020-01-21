package com.CezaryZal.api.day.manager.creator;

import com.CezaryZal.api.day.model.ObjectToSaveDay;
import com.CezaryZal.api.day.model.entity.Day;
import com.CezaryZal.api.report.shortened.model.entity.ShortReport;
import org.springframework.stereotype.Service;

@Service
public class DayCreator {

    public Day createByDayApiAndShortDay(ObjectToSaveDay day, ShortReport shortReport){
        return new Day(
                day.getId(),
                day.getDate(),
                day.getUserId(),
                day.getPortionsDrink(),
                day.getPortionsAlcohol(),
                day.getPortionsSnack(),
                shortReport
        );
    }
}
