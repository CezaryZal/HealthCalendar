package com.CezaryZal.api.day.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@Getter
@AllArgsConstructor
public abstract class FormDay {

    private Long id;
    private LocalDate date;
    private Long userId;
    private int portionsDrink;
    private int portionsAlcohol;
    private int portionsSnack;

    public void setId(Long id) {
        this.id = id;
    }
}
