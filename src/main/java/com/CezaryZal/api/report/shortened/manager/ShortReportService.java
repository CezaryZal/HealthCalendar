package com.CezaryZal.api.report.shortened.manager;

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

    @Autowired
    public ShortReportService(ShortReportRepository shortReportRepository,
                              ShortReportConverter shortReportConverter) {
        this.shortReportRepository = shortReportRepository;
        this.shortReportConverter = shortReportConverter;
    }

    public ShortReportDto getShortReportDtoById(Long id) {
        ShortReport shortReport = shortReportRepository.findById(id)
                .orElseThrow(() -> new ShortReportNotFoundException("Short report not found by id"));
        return getShortReportDtoByShortReport(shortReport);
    }

    public ShortReportDto getShortReportDtoByDateAndUserId(String inputDate, Long userId) {
        ShortReport shortReport = shortReportRepository.findShortReportByDateAndUserId(LocalDate.parse(inputDate), userId)
                .orElseThrow(() -> new ShortReportNotFoundException("Short report not found by date and user id"));
        return getShortReportDtoByShortReport(shortReport);
    }

    public ShortReportDto getShortReportDtoByShortReport(ShortReport shortReport) {
        return shortReportConverter.mappingShortReportToDto(shortReport);
    }

    public List<ShortReportDto> getShortReportsByInputDateAndUserId(String inputDate, Long userId) {
        return getShortReportsByDateAndUserId(LocalDate.parse(inputDate), userId);
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
}
