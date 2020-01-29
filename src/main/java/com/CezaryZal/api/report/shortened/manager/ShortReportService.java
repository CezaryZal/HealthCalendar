package com.CezaryZal.api.report.shortened.manager;

import com.CezaryZal.api.day.model.ObjectToSaveDay;
import com.CezaryZal.api.report.shortened.manager.creator.ShortReportCreator;
import com.CezaryZal.api.report.shortened.manager.mapper.ShortReportConverter;
import com.CezaryZal.api.report.shortened.manager.repo.ShortReportRepoService;
import com.CezaryZal.api.report.shortened.model.entity.ShortReport;
import com.CezaryZal.api.report.shortened.model.ShortReportDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ShortReportService {

    private final ShortReportRepoService shortReportRepoService;
    private final ShortReportConverter shortReportConverter;
    private final ShortReportCreator shortReportCreator;

    @Autowired
    public ShortReportService(ShortReportRepoService shortReportRepoService,
                              ShortReportConverter shortReportConverter,
                              ShortReportCreator shortReportCreator) {
        this.shortReportRepoService = shortReportRepoService;
        this.shortReportConverter = shortReportConverter;
        this.shortReportCreator = shortReportCreator;
    }

    public ShortReportDto getShortReportDtoById(Long id) {
        return shortReportConverter.mappingShortReportToDto(shortReportRepoService.getShortReportById(id));
    }

    public ShortReportDto getShortReportDtoByDateAndUserId(LocalDate localDate, Long userId) {
        return shortReportConverter.mappingShortReportToDto(
                shortReportRepoService.getShortReportByDateAndUserId(localDate, userId));
    }

    public List<ShortReportDto> getShortReportsByInputDateAndUserId(String inputDate, Long userId) {
        return getShortReportsByDateAndUserId(LocalDate.parse(inputDate), userId);
    }

    public ShortReport createShortReport(ObjectToSaveDay saveDay, Long dayId, boolean isNewObject){
        return isNewObject? shortReportCreator.createNewShortReport(saveDay) :
                shortReportCreator.createToUpdateRecordByDay(saveDay, dayId);
    }

    public List<ShortReportDto> getShortReportsByDateAndUserId(LocalDate inputLocalDate, Long userId) {
        LocalDate localDateMin = inputLocalDate.minusDays(30);
        LocalDate localDateMax = inputLocalDate.plusDays(30);
        List<ShortReport> shortReportsByDateAndUserId =
                shortReportRepoService.getShortsReportByMaxMinDateAndUserId(localDateMin, localDateMax, userId);
        return shortReportConverter.mappingListShortReportToDto(shortReportsByDateAndUserId);
    }

    public List<ShortReportDto> getShorts() {
        return shortReportConverter.mappingListShortReportToDto(shortReportRepoService.getAll());
    }

}
