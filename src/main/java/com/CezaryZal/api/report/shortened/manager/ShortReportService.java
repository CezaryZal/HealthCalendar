package com.CezaryZal.api.report.shortened.manager;

import com.CezaryZal.api.day.model.ObjectToSaveDay;
import com.CezaryZal.api.report.shortened.repo.ShortReportRepository;
import com.CezaryZal.api.report.shortened.model.entity.ShortReport;
import com.CezaryZal.api.report.shortened.model.ShortReportDto;
import com.CezaryZal.exceptions.not.found.ShortReportNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ShortReportService {

    private final ShortReportRepository shortReportRepository;
    private final ShortReportConverter shortReportConverter;
    private final ShortReportCreator shortReportCreator;

    @Autowired
    public ShortReportService(ShortReportRepository shortReportRepository,
                              ShortReportConverter shortReportConverter,
                              ShortReportCreator shortReportCreator) {
        this.shortReportRepository = shortReportRepository;
        this.shortReportConverter = shortReportConverter;
        this.shortReportCreator = shortReportCreator;
    }

    public ShortReportDto getShortReportDtoById(Long id) {
        ShortReport shortReport = shortReportRepository.findById(id)
                .orElseThrow(() -> new ShortReportNotFoundException("Short report not found by id"));
        return shortReportConverter.mappingShortReportToDto(shortReport);
    }

    public ShortReportDto getShortReportDtoByDateAndUserId(LocalDate localDate, Long userId) {
        ShortReport shortReport = shortReportRepository.findShortReportByDateAndUserId(localDate, userId)
                .orElseThrow(() -> new ShortReportNotFoundException("Short report not found by date and user id"));
        return shortReportConverter.mappingShortReportToDto(shortReport);
    }

    public List<ShortReportDto> getShortReportsByInputDateAndUserId(String inputDate, Long userId) {
        return getShortReportsByDateAndUserId(LocalDate.parse(inputDate), userId);
    }

    public ShortReport createShortReport(ObjectToSaveDay saveDay, Long dayId, boolean isNewObject){
        Long shortReportId = getShortReportIdByDateAndUserId(saveDay.getDate(), saveDay.getUserId());
        return isNewObject? shortReportCreator.createNewShortReport(saveDay) :
                shortReportCreator.createShortReportToUpdateRecordByDay(saveDay, dayId, shortReportId);
    }

    public List<ShortReportDto> getShortReportsByDateAndUserId(LocalDate inputLocalDate, Long userId) {
        LocalDate localDateMin = inputLocalDate.minusDays(30);
        LocalDate localDateMax = inputLocalDate.plusDays(30);
        List<ShortReport> listShortReport =
                shortReportRepository.findShortDayByUserIdAndMonthForwardAndBackward(userId, localDateMin, localDateMax);
        return shortReportConverter.mappingListShortReportToDto(listShortReport);
    }

    public List<ShortReportDto> getShorts() {
        return shortReportConverter.mappingListShortReportToDto(shortReportRepository.findAll());
    }

    private Long getShortReportIdByDateAndUserId(LocalDate localDate, Long userId){
        return shortReportRepository.getIdByDateAndUserId(localDate, userId)
                .orElseThrow(() -> new ShortReportNotFoundException("Short report not found by date and user id"));
    }

}
