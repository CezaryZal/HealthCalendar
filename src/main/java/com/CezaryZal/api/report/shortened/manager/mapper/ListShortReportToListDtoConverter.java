package com.CezaryZal.api.report.shortened.manager.mapper;

import com.CezaryZal.api.report.shortened.model.entity.ShortReport;
import com.CezaryZal.api.report.shortened.model.ShortReportDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListShortReportToListDtoConverter {

    private final ShortReportToDtoConverter shortReportToDtoConverter;

    @Autowired
    public ListShortReportToListDtoConverter(ShortReportToDtoConverter shortReportToDtoConverter) {
        this.shortReportToDtoConverter = shortReportToDtoConverter;
    }

    public List<ShortReportDto> mappingList(List<ShortReport> shortReportsDto){
        return shortReportsDto.stream()
                .map(shortReportToDtoConverter::mappingEntity)
                .collect(Collectors.toList());
    }
}
