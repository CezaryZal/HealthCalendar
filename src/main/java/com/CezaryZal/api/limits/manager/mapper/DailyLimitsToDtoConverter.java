package com.CezaryZal.api.limits.manager.mapper;

import com.CezaryZal.api.limits.entity.DailyLimits;
import com.CezaryZal.api.limits.entity.DailyLimitsDto;
import org.springframework.stereotype.Service;

@Service
public class DailyLimitsToDtoConverter {

    public DailyLimitsDto mappingEntity(DailyLimits dailyLimits){
        return new DailyLimitsDto(
                dailyLimits.getId(),
                dailyLimits.getKcalDemandPerDay(),
                dailyLimits.getDrinkDemandPerDay(),
                dailyLimits.getUserId());
    }
}
