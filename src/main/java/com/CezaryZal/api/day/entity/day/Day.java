package com.CezaryZal.api.day.entity.day;

import com.CezaryZal.api.shortReport.entity.ShortReport;
import com.CezaryZal.api.meal.entity.Meal;
import com.CezaryZal.api.note.entity.Note;
import com.CezaryZal.api.training.entity.Training;
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
@AllArgsConstructor
@NoArgsConstructor
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    //    @NotBlank
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
//    @JsonDeserialize(using = LocalDateDeserializer.class)
//    @JsonSerialize(using = LocalDateSerializer.class)
    @Column(name = "date")
    private LocalDate date;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "portions_drink")
    private int portionsDrink;

    @Column(name = "portions_alcohol")
    private int portionsAlcohol;


    //loading like EAGER
    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "day_id")
    @BatchSize(size = 5)
    private List<Meal> listMealsDB;

    @Column(name = "portions_snack")
    private int portionsSnack;

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "day_id")
    @BatchSize(size = 2)
    private List<Training> listTrainingsDB;

    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "day_id")
    private List<Note> listNotesDB;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "short_day_id")
    private ShortReport shortReport;

    public Day(LocalDate date,
               Long userId,
               int portionsDrink,
               int portionsAlcohol,
               int portionsSnack) {
        this.date = date;
        this.userId = userId;
        this.portionsDrink = portionsDrink;
        this.portionsAlcohol = portionsAlcohol;
        this.portionsSnack = portionsSnack;
    }

    public Day(Long id,
               LocalDate date,
               Long userId,
               int portionsDrink,
               int portionsAlcohol,
               int portionsSnack,
               ShortReport shortReport) {
        this.id = id;
        this.date = date;
        this.userId = userId;
        this.portionsDrink = portionsDrink;
        this.portionsAlcohol = portionsAlcohol;
        this.portionsSnack = portionsSnack;
        this.shortReport = shortReport;
    }




}
