package com.CezaryZal.api.day;

import com.CezaryZal.api.shortday.ShortDay;
import com.CezaryZal.api.meal.entity.Meal;
import com.CezaryZal.api.note.entity.Note;
import com.CezaryZal.api.training.entity.Training;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

//@BatchSize-jakbym potrzebował ściągnąć pełne dane z kilku dni (dla poprawy wydajności, N+1)
//Do optymalizacji można spróbować EAGER(przy obecnej koncepcji. Przy biżącym pobieraniu danych LAZY)

@Entity
@Table(name = "day")
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
    private ShortDay shortDay;


    public Day() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getPortionsDrink() {
        return portionsDrink;
    }

    public void setPortionsDrink(int portionsDrink) {
        this.portionsDrink = portionsDrink;
    }

    public int getPortionsAlcohol() {
        return portionsAlcohol;
    }

    public void setPortionsAlcohol(int portionsAlcohol) {
        this.portionsAlcohol = portionsAlcohol;
    }

    public List<Meal> getListMealsDB() {
        return listMealsDB;
    }

    public void setListMealsDB(List<Meal> listMealsDB) {
        this.listMealsDB = listMealsDB;
    }

    public int getPortionsSnack() {
        return portionsSnack;
    }

    public void setPortionsSnack(int portionsSnack) {
        this.portionsSnack = portionsSnack;
    }

    public List<Training> getListTrainingsDB() {
        return listTrainingsDB;
    }

    public void setListTrainingsDB(List<Training> listTrainingsDB) {
        this.listTrainingsDB = listTrainingsDB;
    }

    public List<Note> getListNotesDB() {
        return listNotesDB;
    }

    public void setListNotesDB(List<Note> listNotesDB) {
        this.listNotesDB = listNotesDB;
    }

    public ShortDay getShortDay() {
        return shortDay;
    }

    public void setShortDay(ShortDay shortDay) {
        this.shortDay = shortDay;
    }

    @Override
    public String toString() {
        return "DayDB{" +
                "id=" + id +
                ", date=" + date +
                ", userId=" + userId +
                ", portionsDrink=" + portionsDrink +
                ", portionsAlcohol=" + portionsAlcohol +
                ", listMealsDB=" + listMealsDB +
                ", portionsSnack=" + portionsSnack +
                ", listTrainingsDB=" + listTrainingsDB +
                ", listNotesDB=" + listNotesDB +
                ", shortDay=" + shortDay +
                '}';
    }
}
