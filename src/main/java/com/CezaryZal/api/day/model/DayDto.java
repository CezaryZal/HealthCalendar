package com.CezaryZal.api.day.model;

import com.CezaryZal.api.meal.entity.Meal;
import com.CezaryZal.api.note.entity.Note;
import com.CezaryZal.api.report.shortened.model.entity.ShortReport;
import com.CezaryZal.api.training.model.entity.Training;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@ToString
@Getter
public class DayDto extends FormDay {

    private List<Meal> listMealsDB;
    private List<Training> listTrainingsDB;
    private List<Note> listNotesDB;
    private ShortReport shortReport;

    public DayDto(
            Long id,
            LocalDate date,
            Long userId,
            int portionsDrink,
            int portionsAlcohol,
            int portionsSnack,
            List<Meal> listMealsDB,
            List<Training> listTrainingsDB,
            List<Note> listNotesDB,
            ShortReport shortReport) {
        super(id, date, userId, portionsDrink, portionsAlcohol, portionsSnack);
        this.listMealsDB = listMealsDB;
        this.listTrainingsDB = listTrainingsDB;
        this.listNotesDB = listNotesDB;
        this.shortReport = shortReport;
    }

}
