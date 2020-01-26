package com.CezaryZal.api.training.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.LocalTime;

@ToString
@Getter
@NoArgsConstructor
public abstract class FormTraining {

    private Long id;
    private LocalDateTime dateTimeOfExecution;
    private String description;
    private LocalTime elapsedTime;
    private int burnKcal;
    private Long dayId;

    public static final class Builder{
        private Long id;
        private LocalDateTime dateTimeOfExecution;
        private String description;
        private LocalTime elapsedTime;
        private int burnKcal;
        private Long dayId;

        public static Builder builder(){
            return new Builder();
        }

        public Builder id(Long id){
            this.id = id;
            return this;
        }
        public Builder dateTimeOfExecution(LocalDateTime dateTimeOfExecution){
            this.dateTimeOfExecution = dateTimeOfExecution;
            return this;
        }
        public Builder description(String description){
            this.description = description;
            return this;
        }
        public Builder elapsedTime(LocalTime elapsedTime){
            this.elapsedTime = elapsedTime;
            return this;
        }
        public Builder burnKcal(int burnKcal){
            this.burnKcal = burnKcal;
            return this;
        }
        public Builder dayId(Long dayId){
            this.dayId = dayId;
            return this;
        }

        public FormTraining build(){
            FormTraining formTraining = new TrainingDto();
            return passDateToObject(formTraining);
        }

        private FormTraining passDateToObject(FormTraining formTraining){
            formTraining.id = this.id;
            formTraining.dateTimeOfExecution = this.dateTimeOfExecution;
            formTraining.description = this.description;
            formTraining.elapsedTime = this.elapsedTime;
            formTraining.burnKcal = this.burnKcal;
            formTraining.dayId = this.dayId;
            return formTraining;
        }
    }
}
