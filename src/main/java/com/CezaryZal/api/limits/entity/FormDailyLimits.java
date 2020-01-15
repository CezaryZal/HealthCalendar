package com.CezaryZal.api.limits.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public abstract class FormDailyLimits {

    private Long id;
    private int kcalDemandPerDay;
    private int drinkDemandPerDay;
    private Long userId;
}
