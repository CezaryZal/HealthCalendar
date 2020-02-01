package com.CezaryZal.api.report.shortened.manager;

import com.CezaryZal.api.report.shortened.model.ShortReportDto;
import com.CezaryZal.api.report.shortened.model.entity.ShortReport;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShortReportConverter {

    ShortReportDto mappingShortReportToDto(ShortReport shortReport){
        return ShortReportDto.builder()
                .id(shortReport.getId())
                .date(shortReport.getDate())
                .isAchievedKcal(shortReport.isAchievedKcal())
                .isAchievedDrink(shortReport.isAchievedDrink())
                .isAlcohol(shortReport.isAlcohol())
                .isSnacks(shortReport.isSnacks())
                .build();
    }

    List<ShortReportDto> mappingListShortReportToDto(List<ShortReport> shortReportsDto){
        return shortReportsDto.stream()
                .map(this::mappingShortReportToDto)
                .collect(Collectors.toList());
    }
}
