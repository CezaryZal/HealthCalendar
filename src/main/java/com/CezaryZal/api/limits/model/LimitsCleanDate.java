package com.CezaryZal.api.limits.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class LimitsCleanDate {

    private int kcalDemandPerDay;
    private int drinkDemandPerDay;
}
