package com.CezaryZal.api.body.entity;

import java.time.LocalDate;

public class BodySizeDao extends FormBodySize{

    public BodySizeDao(
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
