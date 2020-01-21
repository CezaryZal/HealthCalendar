package com.CezaryZal.api.limits.manager.mapper;

import com.CezaryZal.api.limits.model.entity.DailyLimits;
import com.CezaryZal.api.limits.model.DailyLimitsDto;
import com.CezaryZal.api.user.model.AccountEntity;
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

    public DailyLimits mappingAccountEntityToDailyLimits(AccountEntity accountEntity){
        return new DailyLimits(
                accountEntity.getKcalDemandPerDay(),
                accountEntity.getDrinkDemandPerDay()
        );
    }

}
