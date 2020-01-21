package com.CezaryZal.api.report.model;

import com.CezaryZal.api.meal.model.DailyDiet;
import com.CezaryZal.api.note.model.Header;
import com.CezaryZal.api.report.shortened.model.ShortReportDto;
import com.CezaryZal.api.training.model.TrainingsSummary;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@ToString
@Getter
public class LongReport extends FormReport {

    private DailyDiet dailyDiet;
    private TrainingsSummary trainings;
    private List<Header> listHeaders;
    private List<ShortReportDto> listShortsDayDto;

    public LongReport(Long id,
                      LocalDate date,
                      Long userId,
                      int portionsDrink,
                      int portionsAlcohol,
                      int portionsSnack,
                      String nick,
                      LocalDate lastDateMeasureBody,
                      boolean isAchievedDrink,
                      boolean isAchievedKcal,
                      DailyDiet dailyDiet,
                      TrainingsSummary trainings,
                      List<Header> listHeaders,
                      List<ShortReportDto> listShortsDayDto) {
        super(id,
                date,
                userId,
                portionsDrink,
                portionsAlcohol,
                portionsSnack,
                nick,
                lastDateMeasureBody,
                isAchievedDrink,
                isAchievedKcal);
        this.dailyDiet = dailyDiet;
        this.trainings = trainings;
        this.listHeaders = listHeaders;
        this.listShortsDayDto = listShortsDayDto;
    }
}
