package com.CezaryZal.api.day.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@Getter
@NoArgsConstructor
public class ObjectToSaveDay{

    private Long id;
    private LocalDate date;
    private Long userId;
    private int portionsDrink;
    private int portionsAlcohol;
    private int portionsSnack;


    public static final class Builder{
        private Long id;
        private LocalDate date;
        private Long userId;
        private int portionsDrink;
        private int portionsAlcohol;
        private int portionsSnack;

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

        public ObjectToSaveDay build(){
            ObjectToSaveDay objectToSaveDay = new ObjectToSaveDay();
            objectToSaveDay.id = this.id;
            objectToSaveDay.date = this.date;
            objectToSaveDay.userId = this.userId;
            objectToSaveDay.portionsDrink = this.portionsDrink;
            objectToSaveDay.portionsAlcohol = this.portionsAlcohol;
            objectToSaveDay.portionsSnack = this.portionsSnack;
            return objectToSaveDay;
        }
    }
}
