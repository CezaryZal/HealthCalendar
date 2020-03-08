package com.CezaryZal.api.day.model.entity;

import com.CezaryZal.api.day.model.DayDto;
import com.CezaryZal.api.report.shortened.model.entity.ShortReport;
import com.CezaryZal.api.meal.model.entity.Meal;
import com.CezaryZal.api.note.model.entity.Note;
import com.CezaryZal.api.training.model.entity.Training;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

//@BatchSize-jakbym potrzebował ściągnąć pełne dane z kilku dni (dla poprawy wydajności, N+1)

@Entity
@Table(name = "day")
@Data
@NoArgsConstructor
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    //    @NotBlank
    @Column(name = "date")
    private LocalDate date;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "portions_drink")
    private int portionsDrink;

    @Column(name = "portions_alcohol")
    private int portionsAlcohol;

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.TRUE)
    @JoinColumn(name = "day_id")
    @BatchSize(size = 5)
    private List<Meal> listMealsDB;

    @Column(name = "portions_snack")
    private int portionsSnack;

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.TRUE)
    @JoinColumn(name = "day_id")
    @BatchSize(size = 2)
    private List<Training> listTrainingsDB;

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.TRUE)
    @JoinColumn(name = "day_id")
    private List<Note> listNotesDB;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "short_day_id")
    private ShortReport shortReport;

    public static Builder builder(){
        return new Builder();
    }

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

        public Day build(){
            Day day = new Day();
            day.id = this.id;
            day.date = this.date;
            day.userId = this.userId;
            day.portionsDrink = this.portionsDrink;
            day.portionsAlcohol = this.portionsAlcohol;
            day.portionsSnack = this.portionsSnack;
            day.listMealsDB = this.listMealsDB;
            day.listTrainingsDB = this.listTrainingsDB;
            day.listNotesDB = this.listNotesDB;
            day.shortReport = this.shortReport;
            return day;
        }
    }
}
