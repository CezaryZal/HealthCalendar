package com.CezaryZal.api.report.shortened.manager.creator;

import com.CezaryZal.api.day.model.ObjectToSaveDay;
import com.CezaryZal.api.report.shortened.model.entity.ShortReport;
import org.springframework.stereotype.Service;

@Service
public class ObjectToSaveDayToShortDayConverter {

    public ShortReport mappingEntity(ObjectToSaveDay day)  {

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
