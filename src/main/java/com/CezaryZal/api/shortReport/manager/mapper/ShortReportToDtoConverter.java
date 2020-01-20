package com.CezaryZal.api.shortReport.manager.mapper;

import com.CezaryZal.api.shortReport.entity.ShortReport;
import com.CezaryZal.api.shortReport.entity.ShortReportDto;
import org.springframework.stereotype.Service;

@Service
public class ShortReportToDtoConverter {

    public ShortReportDto mappingEntity(ShortReport shortReport){
        return new ShortReportDto(
                shortReport.getId(),
                shortReport.getUserId(),
                shortReport.getDate(),
                shortReport.isAchievedKcal(),
                shortReport.isAchievedDrink(),
                shortReport.isAlcohol(),
                shortReport.isSnacks()
        );
    }
}
