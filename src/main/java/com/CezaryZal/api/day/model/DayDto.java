package com.CezaryZal.api.day.model;

import com.CezaryZal.api.meal.model.entity.Meal;
import com.CezaryZal.api.note.model.entity.Note;
import com.CezaryZal.api.report.shortened.model.entity.ShortReport;
import com.CezaryZal.api.training.model.entity.Training;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@ToString
@Getter
@NoArgsConstructor
public class DayDto {

    private Long id;
    private LocalDate date;
    private Long userId;
    private int portionsDrink;
    private int portionsAlcohol;
    private int portionsSnack;
    private List<Meal> listMealsDB;
    private List<Training> listTrainingsDB;
    private List<Note> listNotesDB;
    private ShortReport shortReport;


    public static final class Builder{
        private Long id;
        private LocalDate date;
        private Long userId;
        private int portionsDrink;
        private int portionsAlcohol;
        private int portionsSnack;
        private List<Meal> listMealsDB;
        private List<Training> listTrainingsDB;
        private List<Note> listNotesDB;
        private ShortReport shortReport;

        public static Builder builder(){
            return new Builder();
        }

        public Builder id(Long id){
            this.id = id;
            return this;
        }
        public Builder date(LocalDate date){
            this.date = date;
            return this;
        }
        public Builder userId(Long userId){
            this.userId = userId;
            return this;
        }
        public Builder portionsDrink(int portionsDrink){
            this.portionsDrink = portionsDrink;
            return this;
        }
        public Builder portionsAlcohol(int portionsAlcohol){
            this.portionsAlcohol = portionsAlcohol;
            return this;
        }
        public Builder portionsSnack(int portionsSnack){
            this.portionsSnack = portionsSnack;
            return this;
        }
        public Builder listMeal(List<Meal> listMeals){
            this.listMealsDB = listMeals;
            return this;
        }
        public Builder listTrainings(List<Training> listTrainings){
            this.listTrainingsDB = listTrainings;
            return this;
        }
        public Builder listNotes(List<Note> listNotes) {
            this.listNotesDB = listNotes;
            return this;
        }
        public Builder shortReport(ShortReport shortReport){
            this.shortReport = shortReport;
            return this;
        }

        public DayDto build(){
            DayDto dayDto = new DayDto();
            dayDto.id = this.id;
            dayDto.date = this.date;
            dayDto.userId = this.userId;
            dayDto.portionsDrink = this.portionsDrink;
            dayDto.portionsAlcohol = this.portionsAlcohol;
            dayDto.portionsSnack = this.portionsSnack;
            dayDto.listMealsDB = this.listMealsDB;
            dayDto.listTrainingsDB = this.listTrainingsDB;
            dayDto.listNotesDB = this.listNotesDB;
            dayDto.shortReport = this.shortReport;
            return dayDto;
        }
    }
}
