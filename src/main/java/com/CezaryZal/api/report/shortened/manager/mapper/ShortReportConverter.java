package com.CezaryZal.api.report.shortened.manager.mapper;

import com.CezaryZal.api.day.model.ObjectToSaveDay;
import com.CezaryZal.api.report.shortened.model.ShortReportDto;
import com.CezaryZal.api.report.shortened.model.entity.ShortReport;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShortReportConverter {

    public ShortReport mappingObjectToSaveDayToShortReport(ObjectToSaveDay day)  {

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

    public ShortReportDto mappingShortReportToDto(ShortReport shortReport){
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

    public List<ShortReportDto> mappingListShortReportToDto(List<ShortReport> shortReportsDto){
        return shortReportsDto.stream()
                .map(this::mappingShortReportToDto)
                .collect(Collectors.toList());
    }
}
