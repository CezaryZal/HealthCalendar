package com.CezaryZal.api.limits.manager.mapper;

import com.CezaryZal.api.limits.entity.DailyLimits;
import com.CezaryZal.api.limits.entity.DailyLimitsDto;
import org.springframework.stereotype.Service;

@Service
public class DtoToDailyLimitsConverter {

    public DailyLimits mappingEntity(DailyLimitsDto dailyLimitsDto){
        return new DailyLimits(
                dailyLimitsDto.getId(),
                dailyLimitsDto.getKcalDemandPerDay(),
                dailyLimitsDto.getDrinkDemandPerDay(),
                dailyLimitsDto.getUserId());
    }
}
