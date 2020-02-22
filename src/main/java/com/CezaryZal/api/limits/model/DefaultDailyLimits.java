package com.CezaryZal.api.limits.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class DefaultDailyLimits {

    private int kcalDemandPerDay;
    private int drinkDemandPerDay;
}
