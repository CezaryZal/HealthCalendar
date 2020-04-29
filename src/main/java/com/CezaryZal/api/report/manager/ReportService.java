package com.CezaryZal.api.report.manager;

import com.CezaryZal.api.day.manager.DayService;
import com.CezaryZal.api.report.model.BasicReport;
import com.CezaryZal.api.report.model.FormReport;
import com.CezaryZal.api.day.model.entity.Day;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

    private final DayService dayService;
    private final ReportCreator reportCreator;

    @Autowired
    public ReportService(DayService dayService, ReportCreator reportCreator) {
        this.dayService = dayService;
        this.reportCreator = reportCreator;
    }

    public FormReport getFormReportByDateAndUserId(String inputDate, Long userId, boolean isLongReport){
        Day day = dayService.getDayByDateAndUserId(inputDate, userId);
        return reportCreator.createFormReportByDayAndUser(day, userId, isLongReport);
    }

    public BasicReport getBasicReportByLoginNameAndUserId(String loginName){
        return reportCreator.creatBasicReport(loginName);
    }
}
