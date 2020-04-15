package com.CezaryZal.api.meal.model;

import com.CezaryZal.api.ApiEntityDto;
import com.CezaryZal.validation.annotation.ActualDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

@ToString
@Getter
@EqualsAndHashCode
@NoArgsConstructor
public class MealDto implements ApiEntityDto {

    @Positive
    private Long id;

    @NotNull(message = "The 'dateTimeOfEat' should not be null")
    @ActualDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd_HH:mm")
    private LocalDateTime dateTimeOfEat;

    @NotBlank(message = "The 'type' should not be blank")
    @Size(min = 4, max = 20, message = "The 'type' should be between 3 and 20 characters")
    private String type;

    @NotNull(message = "The 'kcal' should not be null")
    @Max(value = 1500, message = "The value of kcal entered is too big, max is 1500")
    @Min(value = 50, message = "The value of kcal entered is too small, min is 50")
    private int kcal;

    @NotBlank(message = "The 'description' should not be blank")
    @Size(min = 4, max = 100, message = "The 'description' should be between 3 and 100 characters")
    private String description;

    @NotNull(message = "The 'dayId' should not be null")
    @Positive
    private Long dayId;


    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private Long id;
        private LocalDateTime dateTimeOfEat;
        private String type;
        private int kcal;
        private String description;
        private Long dayId;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder dateTimeOfEat(LocalDateTime dateTimeOfEat) {
            this.dateTimeOfEat = dateTimeOfEat;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder kcal(int kcal) {
            this.kcal = kcal;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder dayId(Long dayId) {
            this.dayId = dayId;
            return this;
        }

        public MealDto build() {
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
