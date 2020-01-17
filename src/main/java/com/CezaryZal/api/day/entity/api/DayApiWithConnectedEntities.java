package com.CezaryZal.api.day.entity.api;

import com.CezaryZal.api.day.entity.FormDay;
import com.CezaryZal.api.meal.entity.DailyDiet;
import com.CezaryZal.api.note.entity.Header;
import com.CezaryZal.api.shortday.entity.ShortDayDto;
import com.CezaryZal.api.training.entity.TrainingsSummary;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@ToString
@Getter
public class DayApiWithConnectedEntities extends FormDay {

    private String nick;
    private LocalDate lastDateMeasureBody;
    private boolean isAchievedDrink;
    private DailyDiet dailyDiet;
    private boolean isAchievedKcal;
    private TrainingsSummary trainings;
    private List<Header> listHeaders;
    private List<ShortDayDto> listShortsDayDto;

    public DayApiWithConnectedEntities(
            Long id,
            LocalDate date,
            Long userId,
            int portionsDrink,
            int portionsAlcohol,
            int portionsSnack,
            String nick,
            LocalDate lastDateMeasureBody,
            boolean isAchievedDrink,
            DailyDiet dailyDiet,
            boolean isAchievedKcal,
            TrainingsSummary trainings,
            List<Header> listHeaders,
            List<ShortDayDto> listShortsDayDto) {
        super(id, date, userId, portionsDrink, portionsAlcohol, portionsSnack);
        this.nick = nick;
        this.lastDateMeasureBody = lastDateMeasureBody;
        this.isAchievedDrink = isAchievedDrink;
        this.dailyDiet = dailyDiet;
        this.isAchievedKcal = isAchievedKcal;
        this.trainings = trainings;
        this.listHeaders = listHeaders;
        this.listShortsDayDto = listShortsDayDto;
    }

}
