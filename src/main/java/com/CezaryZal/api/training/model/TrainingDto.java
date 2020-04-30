package com.CezaryZal.api.training.model;

import com.CezaryZal.validation.annotation.ActualDate;
import com.CezaryZal.validation.annotation.Timeline;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@ToString
@Getter
@EqualsAndHashCode
@NoArgsConstructor
public class TrainingDto {

    @Positive
    private Long id;

    @NotNull(message = "The 'dateTimeOfExecution' should not be null")
    @ActualDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd_HH:mm")
    private LocalDateTime dateTimeOfExecution;

    @NotBlank(message = "The 'description' should not be blank")
    @Size(min = 4, max = 100, message = "The 'description' should be between 3 and 100 characters")
    private String description;

    @NotNull(message = "The 'elapsedTime' should not be null")
    @Timeline
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime elapsedTime;

    @NotNull(message = "The 'burnKcal' should not be null")
    @Max(value = 6000, message = "The value of burnKcal entered is too big, max is 6000")
    @Min(value = 30, message = "The value of burnKcal entered is too small, min is 30")
    private int burnKcal;

    private Long dayId;


    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private Long id;
        private LocalDateTime dateTimeOfExecution;
        private String description;
        private LocalTime elapsedTime;
        private int burnKcal;
        private Long dayId;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder dateTimeOfExecution(LocalDateTime dateTimeOfExecution) {
            this.dateTimeOfExecution = dateTimeOfExecution;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder elapsedTime(LocalTime elapsedTime) {
            this.elapsedTime = elapsedTime;
            return this;
        }

        public Builder burnKcal(int burnKcal) {
            this.burnKcal = burnKcal;
            return this;
        }

        public Builder dayId(Long dayId) {
            this.dayId = dayId;
            return this;
        }

        public TrainingDto buildDto() {
            TrainingDto trainingDto = new TrainingDto();
            trainingDto.id = this.id;
            trainingDto.dateTimeOfExecution = this.dateTimeOfExecution;
            trainingDto.description = this.description;
            trainingDto.elapsedTime = this.elapsedTime;
            trainingDto.burnKcal = this.burnKcal;
            trainingDto.dayId = this.dayId;
            return trainingDto;
        }
    }
}
