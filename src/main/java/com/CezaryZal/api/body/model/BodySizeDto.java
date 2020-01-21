package com.CezaryZal.api.body.model;

import java.time.LocalDate;

public class BodySizeDto extends FormBodySize {

    public BodySizeDto(
            Long id,
            int bodyWeight,
            int neckSize,
            int armSize,
            int bustSize,
            int waist,
            int hipsSize,
            int femoralSize,
            int calf,
            LocalDate dateMeasurement,
            Long userId) {
        super(id, bodyWeight, neckSize, armSize, bustSize, waist, hipsSize, femoralSize, calf, dateMeasurement, userId);
    }

}
