package com.CezaryZal.api.shortReport.manager;

import com.CezaryZal.api.shortReport.manager.mapper.ListShortReportToListDtoConverter;
import com.CezaryZal.api.shortReport.manager.mapper.ShortReportToDtoConverter;
import com.CezaryZal.api.shortReport.manager.repo.ShortReportRepoService;
import com.CezaryZal.api.shortReport.entity.ShortReport;
import com.CezaryZal.api.shortReport.entity.ShortReportDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ShortReportService {

    private final ShortReportRepoService shortReportRepoService;
    private final ShortReportToDtoConverter shortReportToDtoConverter;
    private final ListShortReportToListDtoConverter listShortReportToListDtoConverter;

    @Autowired
    public ShortReportService(ShortReportRepoService shortReportRepoService,
                              ShortReportToDtoConverter shortReportToDtoConverter,
                              ListShortReportToListDtoConverter listShortReportToListDtoConverter) {
        this.shortReportRepoService = shortReportRepoService;
        this.shortReportToDtoConverter = shortReportToDtoConverter;
        this.listShortReportToListDtoConverter = listShortReportToListDtoConverter;
    }

    public ShortReportDto getShortReportDtoById(Long id) {
        return shortReportToDtoConverter.mappingEntity(shortReportRepoService.getShortReportById(id));
    }

    public ShortReportDto getShortReportDtoByDateAndUserId(LocalDate localDate, Long userId) {
        return shortReportToDtoConverter.mappingEntity(shortReportRepoService.getShortReportByDateAndUserId(localDate, userId));
    }

    public List<ShortReportDto> getShortReportsByInputDateAndUserId(String inputDate, Long userId) {
        return getShortReportsByDateAndUserId(LocalDate.parse(inputDate), userId);
    }

    public List<ShortReportDto> getShortReportsByDateAndUserId(LocalDate inputLocalDate, Long userId) {
        LocalDate localDateMin = inputLocalDate.minusDays(30);
        LocalDate localDateMax = inputLocalDate.plusDays(30);
        List<ShortReport> shortReportsByDateAndUserId =
                shortReportRepoService.getShortsReportByMaxMinDateAndUserId(localDateMin, localDateMax, userId);
        return listShortReportToListDtoConverter.mappingList(shortReportsByDateAndUserId);
    }

    public List<ShortReportDto> getShorts() {
        return listShortReportToListDtoConverter.mappingList(shortReportRepoService.getAll());
    }

}
