package com.CezaryZal.api.day.manager.mapper;

import com.CezaryZal.api.day.entity.day.DayBasic;
import com.CezaryZal.api.shortReport.entity.ShortReport;
import org.springframework.stereotype.Service;

@Service
public class DayBasicToShortDayConverter {

    public ShortReport mappingEntity(DayBasic day)  {

        return new ShortReport(
                day.getId(),
                day.getUserId(),
                day.getDate(),
                false,
                false,
                day.getPortionsAlcohol() != 0,
                day.getPortionsSnack() != 0
        );
    }
}
