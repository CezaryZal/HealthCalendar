package com.CezaryZal.api.limits.manager.mapper;

import com.CezaryZal.api.limits.entity.DailyLimits;
import com.CezaryZal.api.limits.entity.DailyLimitsDto;
import org.springframework.stereotype.Service;

@Service
public class DailyLimitsConverter {

    public DailyLimitsDto mappingDailyLimitsToDto(DailyLimits dailyLimits){
        return new DailyLimitsDto(
                dailyLimits.getId(),
                dailyLimits.getKcalDemandPerDay(),
                dailyLimits.getDrinkDemandPerDay(),
                dailyLimits.getUserId());
    }

    public DailyLimits mappingDtoToDailyLimits(DailyLimitsDto dailyLimitsDto){
        return new DailyLimits(
                dailyLimitsDto.getId(),
                dailyLimitsDto.getKcalDemandPerDay(),
                dailyLimitsDto.getDrinkDemandPerDay(),
                dailyLimitsDto.getUserId());
    }

}
