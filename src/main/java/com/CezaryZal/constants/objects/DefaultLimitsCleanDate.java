package com.CezaryZal.constants.objects;

import com.CezaryZal.api.limits.model.LimitsCleanDate;

public class DefaultLimitsCleanDate {
    private final int DEFAULT_KCAL_DEMAND_PER_DAY = 8000;
    private final int DEFAULT_DRINK_DEMAND_PER_DAY = 30;

    private final LimitsCleanDate limitsCleanDate = new LimitsCleanDate(
            DEFAULT_KCAL_DEMAND_PER_DAY, DEFAULT_DRINK_DEMAND_PER_DAY);
    private static DefaultLimitsCleanDate defaultLimitsCleanDate = new DefaultLimitsCleanDate();

    private DefaultLimitsCleanDate() {
    }

    public static DefaultLimitsCleanDate getDefaultLimitsCleanDate(){
        return defaultLimitsCleanDate;
    }

    public LimitsCleanDate getLimitsCleanDate(){
        return limitsCleanDate;
    }
}
