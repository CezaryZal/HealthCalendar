package com.CezaryZal.day;

import com.CezaryZal.diet.Diet;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "day")
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    //    @NotBlank
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @Column(name = "date")
    private LocalDate date;

    @Column(name = "user_id")
    private int userId;

//    @Column(name = "last_date_measure_body")
//    private LocalDate lastDateMeasureBody;

    @Column(name = "portions_drink")
    private int portionsDrink;

    @Column(name = "portions_alcohol")
    private int portionsAlcohol;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "day_id")
    private List<Diet> listDiets;


//    @Column(name = "amount_portions_snack")
//    private int amountPortionsSnack;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "note_id")
//    private Note note;

    public Day() {
    }

    public Day(LocalDate date, int userId, int portionsDrink, int portionsAlcohol, List<Diet> listDiets) {
        this.date = date;
        this.userId = userId;
        this.portionsDrink = portionsDrink;
        this.portionsAlcohol = portionsAlcohol;
        this.listDiets = listDiets;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
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

    public List<Diet> getListDiets() {
        return listDiets;
    }

    public void setListDiets(List<Diet> listDiets) {
        this.listDiets = listDiets;
    }

    @Override
    public String toString() {
        return "Day{" +
                "id=" + id +
                ", date=" + date +
                ", userId=" + userId +
                ", portionsDrink=" + portionsDrink +
                ", portionsAlcohol=" + portionsAlcohol +
                ", listDiets=" + listDiets +
                '}';
    }
}
