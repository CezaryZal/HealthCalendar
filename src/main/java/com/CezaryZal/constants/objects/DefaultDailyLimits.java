package com.CezaryZal.constants.objects;
import com.CezaryZal.api.user.limits.model.DailyLimitsTmp;

public class DefaultDailyLimits {
    private final int DEFAULT_KCAL_DEMAND_PER_DAY = 8000;
    private final int DEFAULT_DRINK_DEMAND_PER_DAY = 30;

    private static DefaultDailyLimits defaultLimitsCleanDate = new DefaultDailyLimits();
    private final DailyLimitsTmp limitsCleanDate = new DailyLimitsTmp(
            DEFAULT_KCAL_DEMAND_PER_DAY, DEFAULT_DRINK_DEMAND_PER_DAY);

    private DefaultDailyLimits() {
    }

    public static DefaultDailyLimits getDefaultDailyLimits(){
        return defaultLimitsCleanDate;
    }

    public DailyLimitsTmp getDailyLimitsTmp (){
        return limitsCleanDate;
    }
}
