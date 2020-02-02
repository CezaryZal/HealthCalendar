package com.CezaryZal.api.meal.model;

import com.CezaryZal.api.structure.models.FormEntityDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Getter
@NoArgsConstructor
public class MealDto implements FormEntityDto {

    private Long id;
    private LocalDateTime dateTimeOfEat;
    private String type;
    private int kcal;
    private String description;
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

        public MealDto build(){
            MealDto mealDto = new MealDto();
            mealDto.id = this.id;
            mealDto.dateTimeOfEat = this.dateTimeOfEat;
            mealDto.type = this.type;
            mealDto.kcal = this.kcal;
            mealDto.description = this.description;
            mealDto.dayId = this.dayId;
            return mealDto;
        }
    }
}
