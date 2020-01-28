package com.CezaryZal.api.report.manager;

import com.CezaryZal.api.report.model.FormReport;
import com.CezaryZal.api.day.model.entity.Day;
import com.CezaryZal.api.report.manager.creator.ReportCreator;
import com.CezaryZal.api.day.manager.repo.DayRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

    private final DayRepoService dayRepoService;
    private final ReportCreator reportCreator;

    @Autowired
    public ReportService(DayRepoService dayRepoService, ReportCreator reportCreator) {
        this.dayRepoService = dayRepoService;
        this.reportCreator = reportCreator;
    }

    public FormReport getFormReportByDateAndUserId(String inputDate, Long userId, boolean isLongReport){
        Day day = dayRepoService.getDayByDateAndUserId(inputDate, userId);
        return reportCreator.createByDayAndUser(day, userId, isLongReport);
    }
}
