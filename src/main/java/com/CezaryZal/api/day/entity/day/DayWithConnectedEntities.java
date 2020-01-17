package com.CezaryZal.api.day.entity.day;

import com.CezaryZal.api.day.entity.FormDay;
import com.CezaryZal.api.meal.entity.Meal;
import com.CezaryZal.api.note.entity.Note;
import com.CezaryZal.api.shortday.ShortDay;
import com.CezaryZal.api.training.entity.Training;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@ToString
@Getter
public class DayWithConnectedEntities extends FormDay {

    private List<Meal> listMealsDB;
    private List<Training> listTrainingsDB;
    private List<Note> listNotesDB;
    private ShortDay shortDay;

    public DayWithConnectedEntities(
            Long id,
            LocalDate date,
            Long userId,
            int portionsDrink,
            int portionsAlcohol,
            int portionsSnack,
            List<Meal> listMealsDB,
            List<Training> listTrainingsDB,
            List<Note> listNotesDB,
            ShortDay shortDay) {
        super(id, date, userId, portionsDrink, portionsAlcohol, portionsSnack);
        this.listMealsDB = listMealsDB;
        this.listTrainingsDB = listTrainingsDB;
        this.listNotesDB = listNotesDB;
        this.shortDay = shortDay;
    }

}
