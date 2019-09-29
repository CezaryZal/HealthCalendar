package com.CezaryZal.day;

import com.CezaryZal.diet.Diet;
import com.CezaryZal.drinkLiquids.DrinkLiquids;
import com.CezaryZal.note.Note;
import com.CezaryZal.user.User;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "day")
public class Day {

    //usunięcie user usuwa wszystko
    //usunięcie bodySize; drink; diet niczego innego nie usuwa
    //usuniecie dnia usuwa wszystko po za user

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "date")
    private LocalDate date;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "diet_id")
    private Diet diet;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "drink_liquids_id")
    private DrinkLiquids drink;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "note_id")
    private Note note;

    public Day() {
    }

    public Day(LocalDate date, Diet diet, DrinkLiquids drink, User user, Note note) {
        this.date = date;
        this.diet = diet;
        this.drink = drink;
        this.user = user;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Diet getDietID() {
        return diet;
    }

    public void setDietID(Diet dietID) {
        this.diet = dietID;
    }

    public DrinkLiquids getDrink() {
        return drink;
    }

    public void setDrink(DrinkLiquids drink) {
        this.drink = drink;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Day{" +
                "id=" + id +
                ", date=" + date +
                ", dietID=" + diet +
                ", drink=" + drink +
                ", user=" + user +
                ", note=" + note +
                '}';
    }
}
