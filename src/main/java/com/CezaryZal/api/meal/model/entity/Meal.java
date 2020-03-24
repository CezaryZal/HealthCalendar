package com.CezaryZal.api.meal.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "meal")
@Data
@NoArgsConstructor
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date_time")
    private LocalDateTime dateTimeOfEat;

    @Column(name = "type")
    private String type;

    @Max(value = 1500, message = "The value entered is too big, max is 1500")
    @Min(value = 50, message = "The value entered is too small, min is 50")
    @Column(name = "kcal")
    private int kcal;

    @Column(name = "description")
    private String description;

    @Column(name = "day_id")
    private Long dayId;


    public static Builder builder(){
        return new Builder();
    }

    public static final class Builder{
        private Long id;
        private LocalDateTime dateTimeOfEat;
        private String type;
        private int kcal;
        private String description;
        private Long dayId;

        public Builder id(Long id){
            this.id = id;
            return this;
        }
        public Builder dateTimeOfEat(LocalDateTime dateTimeOfEat){
            this.dateTimeOfEat = dateTimeOfEat;
            return this;
        }
        public Builder type(String type){
            this.type = type;
            return this;
        }
        public Builder kcal(int kcal){
            this.kcal = kcal;
            return this;
        }
        public Builder description(String description){
            this.description = description;
            return this;
        }
        public Builder dayId(Long dayId){
            this.dayId = dayId;
            return this;
        }

        public Meal build(){
            Meal meal = new Meal();
            meal.id = this.id;
            meal.dateTimeOfEat = this.dateTimeOfEat;
            meal.type = this.type;
            meal.kcal = this.kcal;
            meal.description = this.description;
            meal.dayId = this.dayId;
            return meal;
        }
    }
}


