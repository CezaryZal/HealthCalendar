package com.CezaryZal.day;

import com.CezaryZal.bodySize.BodySize;
import com.CezaryZal.diet.Diet;
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

//    @Basic
//    @Temporal(TemporalType.DATE)
    @Column(name = "dateRecord")
    private LocalDate dateRecord;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "body_size_id")
    private BodySize bodySize;

    @Column(name = "last_date_measure_body")
    private LocalDate lastDateMeasureBody;

    @Column(name = "amount_portions_drink")
    private int amountPortionsDrink;

    @Column(name = "min_amount_portions_drink")
    private int minAmountPortionsDrink;

    @Column(name = "amount_portions_alcohol")
    private int amountPortionsAlcohol;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "diet_id")
    private Diet diet;

    @Column(name = "amount_portions_snack")
    private int amountPortionsSnack;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "note_id")
    private Note note;

    public Day() {
    }

    public Day(LocalDate dateRecord, User user, BodySize bodySize, LocalDate lastDateMeasureBody,
               int amountPortionsDrink, int minAmountPortionsDrink, int amountPortionsAlcohol, Diet diet, int amountPortionsSnack, Note note) {
        this.dateRecord = dateRecord;
        this.user = user;
        this.bodySize = bodySize;
        this.lastDateMeasureBody = lastDateMeasureBody;
        this.amountPortionsDrink = amountPortionsDrink;
        this.minAmountPortionsDrink = minAmountPortionsDrink;
        this.amountPortionsAlcohol = amountPortionsAlcohol;
        this.diet = diet;
        this.amountPortionsSnack = amountPortionsSnack;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDateRecord() {
        return dateRecord;
    }

    public void setDateRecord(LocalDate dateRecord) {
        this.dateRecord = dateRecord;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BodySize getBodySize() {
        return bodySize;
    }

    public void setBodySize(BodySize bodySize) {
        this.bodySize = bodySize;
    }

    public LocalDate getLastDateMeasureBody() {
        return lastDateMeasureBody;
    }

    public void setLastDateMeasureBody(LocalDate lastDateMeasureBody) {
        this.lastDateMeasureBody = lastDateMeasureBody;
    }

    public int getAmountPortionsDrink() {
        return amountPortionsDrink;
    }

    public void setAmountPortionsDrink(int amountPortionsDrink) {
        this.amountPortionsDrink = amountPortionsDrink;
    }

    public int getMinAmountPortionsDrink() {
        return minAmountPortionsDrink;
    }

    public void setMinAmountPortionsDrink(int minAmountPortionsDrink) {
        this.minAmountPortionsDrink = minAmountPortionsDrink;
    }

    public int getAmountPortionsAlcohol() {
        return amountPortionsAlcohol;
    }

    public void setAmountPortionsAlcohol(int amountPortionsAlcohol) {
        this.amountPortionsAlcohol = amountPortionsAlcohol;
    }

    public Diet getDiet() {
        return diet;
    }

    public void setDiet(Diet diet) {
        this.diet = diet;
    }

    public int getAmountPortionsSnack() {
        return amountPortionsSnack;
    }

    public void setAmountPortionsSnack(int amountPortionsSnack) {
        this.amountPortionsSnack = amountPortionsSnack;
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
                ", dateRecord=" + dateRecord +
                ", user=" + user +
                ", bodySize=" + bodySize +
                ", lastDateMeasureBody=" + lastDateMeasureBody +
                ", amountPortionsDrink=" + amountPortionsDrink +
                ", minAmountPortionsDrink=" + minAmountPortionsDrink +
                ", amountPortionsAlcohol=" + amountPortionsAlcohol +
                ", diet=" + diet +
                ", amountPortionsSnack=" + amountPortionsSnack +
                ", note=" + note +
                '}';
    }
}
