package com.CezaryZal.api.training.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "training")
@Data
@AllArgsConstructor
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

}
