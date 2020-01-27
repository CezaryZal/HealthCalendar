package com.CezaryZal.api.report.shortened.manager.repo;

import com.CezaryZal.api.report.shortened.ShortReportRepository;
import com.CezaryZal.api.report.shortened.model.entity.ShortReport;
import com.CezaryZal.exceptions.not.found.ShortReportNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ShortReportRepoService {

    private ShortReportRepository shortReportRepository;

    @Autowired
    public ShortReportRepoService(ShortReportRepository shortReportRepository) {
        this.shortReportRepository = shortReportRepository;
    }

    public ShortReport getShortReportById(Long id) {
        return shortReportRepository.findById(id)
                .orElseThrow(() -> new ShortReportNotFoundException("Short report not found by id"));
    }

    public ShortReport getShortReportByDateAndUserId(LocalDate localDate, Long userId) {
        return shortReportRepository.findShortReportByDateAndUserId(localDate, userId)
                .orElseThrow(() -> new ShortReportNotFoundException("Short report not found by date and user id"));
    }

    public Long getShortReportIdByDateAndUserId(LocalDate localDate, Long userId){
        return shortReportRepository.getIdByDateAndUserId(localDate, userId)
                .orElseThrow(() -> new ShortReportNotFoundException("Short report not found by date and user id"));
    }

    public List<ShortReport> getShortsReportByMaxMinDateAndUserId(LocalDate localDateMin, LocalDate localDateMax, Long userId) {
        return shortReportRepository.findShortDayByUserIdAndMonthForwardAndBackward(userId, localDateMin, localDateMax);
    }

    public List<ShortReport> getAll() {
        return shortReportRepository.findAll();
    }

}
