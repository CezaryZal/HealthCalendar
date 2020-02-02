package com.CezaryZal.constants;

import com.CezaryZal.api.limits.model.LimitsCleanDate;
import org.springframework.stereotype.Component;

@Component
public class DefaultLimitsCleanDate {
    private final int DEFAULT_KCAL_DEMAND_PER_DAY = 10000;
    private final int DEFAULT_DRINK_DEMAND_PER_DAY = 10000;

    private LimitsCleanDate defaultLimitsCleanDate;

    public DefaultLimitsCleanDate() {
        this.defaultLimitsCleanDate = new LimitsCleanDate(
                DEFAULT_KCAL_DEMAND_PER_DAY,
                DEFAULT_DRINK_DEMAND_PER_DAY
        );
    }

    public LimitsCleanDate getDefaultLimitsCleanDate(){
        return defaultLimitsCleanDate;
    }
}
