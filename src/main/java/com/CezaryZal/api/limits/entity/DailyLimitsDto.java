package com.CezaryZal.api.limits.entity;

public class DailyLimitsDto extends FormDailyLimits{

    public DailyLimitsDto(
            Long id,
            int kcalDemandPerDay,
            int drinkDemandPerDay,
            Long userId) {
        super(id, kcalDemandPerDay, drinkDemandPerDay, userId);
    }
}
