package com.CezaryZal.api.training.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "training")
@Data
@NoArgsConstructor
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date_time")
    private LocalDateTime dateTimeOfExecution;

    @Column(name = "description")
    private String description;

    @Column(name = "time")
    private LocalTime elapsedTime;

    @Column(name = "burn_kcal")
    private int burnKcal;

    @Column(name = "day_id")
    private Long dayId;


    public static Builder builder(){
        return new Builder();
    }

    public static final class Builder{
        private Long id;
        private LocalDateTime dateTimeOfExecution;
        private String description;
        private LocalTime elapsedTime;
        private int burnKcal;
        private Long dayId;

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

        public Training build(){
            Training training = new Training();
            training.id = this.id;
            training.dateTimeOfExecution = this.dateTimeOfExecution;
            training.description = this.description;
            training.elapsedTime = this.elapsedTime;
            training.burnKcal = this.burnKcal;
            training.dayId = this.dayId;
            return training;
        }
    }
}
