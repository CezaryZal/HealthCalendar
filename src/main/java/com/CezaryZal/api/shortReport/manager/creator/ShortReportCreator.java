package com.CezaryZal.api.shortReport.manager.creator;

import com.CezaryZal.api.day.entity.api.DayApi;
import com.CezaryZal.api.shortReport.manager.repo.ShortReportRepoService;
import com.CezaryZal.api.shortReport.entity.ShortReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShortReportCreator {

    private final ShortReportRepoService shortReportRepoService;

    @Autowired
    public ShortReportCreator(ShortReportRepoService shortReportRepoService) {
        this.shortReportRepoService = shortReportRepoService;
    }

    public ShortReport createByDay(DayApi day)  {
        ShortReport shortReport = shortReportRepoService.getShortReportByDateAndUserId(day.getDate(), day.getUserId());

        return new ShortReport(
                shortReport.getId(),
                day.getUserId(),
                day.getDate(),
                day.isAchievedKcal(),
                day.isAchievedDrink(),
                day.getPortionsAlcohol() != 0,
                day.getPortionsSnack() != 0
        );
    }
}
