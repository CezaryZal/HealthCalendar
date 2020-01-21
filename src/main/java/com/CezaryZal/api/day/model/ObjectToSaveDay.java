package com.CezaryZal.api.day.model;

import com.CezaryZal.api.day.model.FormDay;

import java.time.LocalDate;

public class ObjectToSaveDay extends FormDay {

    public ObjectToSaveDay(
            Long id,
            LocalDate date,
            Long userId,
            int portionsDrink,
            int portionsAlcohol,
            int portionsSnack) {
        super(id, date, userId, portionsDrink, portionsAlcohol, portionsSnack);
    }
}
