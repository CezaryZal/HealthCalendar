package com.CezaryZal.api.report.manager;

import com.CezaryZal.api.report.model.Report;
import com.CezaryZal.api.day.model.entity.Day;
import com.CezaryZal.api.report.model.LongReport;
import com.CezaryZal.api.report.manager.creator.ReportCreator;
import com.CezaryZal.api.report.manager.creator.LongReportCreator;
import com.CezaryZal.api.day.manager.repo.DayRepoService;
import com.CezaryZal.api.user.entity.User;
import com.CezaryZal.api.user.manager.repo.UserRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

    private final DayRepoService dayRepoService;
    private final UserRepoService userRepoService;
    private final ReportCreator reportCreator;
    private final LongReportCreator longReportCreator;

    @Autowired
    public ReportService(DayRepoService dayRepoService,
                         UserRepoService userRepoService,
                         ReportCreator reportCreator,
                         LongReportCreator longReportCreator) {
        this.dayRepoService = dayRepoService;
        this.userRepoService = userRepoService;
        this.reportCreator = reportCreator;
        this.longReportCreator = longReportCreator;
    }

    public Report getDayApiByDateAndUserId(String inputDate, Long userId) {
        Day day = dayRepoService.getDayByDateAndUserId(inputDate, userId);
        User user = userRepoService.getUserById(userId);

        return reportCreator.createByDayAndUser(day, user);
    }

    public LongReport getDayApiWithEntitiesByDateAndUserId(String inputDate, Long userId) {
        Day day = dayRepoService.getDayByDateAndUserId(inputDate, userId);
        User user = userRepoService.getUserById(userId);

        return longReportCreator.createByDayAndUser(day, user);
    }
}
