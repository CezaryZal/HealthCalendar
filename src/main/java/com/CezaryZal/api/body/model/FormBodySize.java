package com.CezaryZal.api.body.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@Getter
@AllArgsConstructor
public abstract class FormBodySize {

    private Long id;
    private int bodyWeight;
    private int neckSize;
    private int armSize;
    private int bustSize;
    private int waist;
    private int hipsSize;
    private int femoralSize;
    private int calf;
    private LocalDate dateMeasurement;
    private Long userId;

}
