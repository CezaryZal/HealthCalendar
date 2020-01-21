package com.CezaryZal.api.meal.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "meal")
@Data
@AllArgsConstructor
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

    @Column(name = "kcal")
    private int kcal;

    @Column(name = "description")
    private String description;

    @Column(name = "day_id")
    private Long dayId;

}


