package com.CezaryZal.api.limits.manager;

import com.CezaryZal.api.limits.model.DailyLimitsDto;
import com.CezaryZal.api.limits.model.entity.DailyLimits;
import org.springframework.stereotype.Service;

@Service
public class DailyLimitsCreator {

    DailyLimits createLimitsToUpdateByDtoAndId(DailyLimitsDto dailyLimitsDto, Long id){
        return new DailyLimits(
                id,
                dailyLimitsDto.getKcalDemandPerDay(),
                dailyLimitsDto.getDrinkDemandPerDay());
    }
}
