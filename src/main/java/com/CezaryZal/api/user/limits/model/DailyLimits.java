package com.CezaryZal.api.user.limits.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class DailyLimits {

    private int kcalDemandPerDay;
    private int drinkDemandPerDay;
}
