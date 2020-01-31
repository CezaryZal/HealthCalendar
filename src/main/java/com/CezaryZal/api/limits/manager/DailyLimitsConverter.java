package com.CezaryZal.api.limits.manager;

import com.CezaryZal.api.limits.model.entity.DailyLimits;
import com.CezaryZal.api.limits.model.DailyLimitsDto;
import com.CezaryZal.api.user.model.AccountEntity;
import org.springframework.stereotype.Service;

@Service
public class DailyLimitsConverter {

    DailyLimitsDto mappingDailyLimitsToDto(DailyLimits dailyLimits){
        return new DailyLimitsDto(
                dailyLimits.getId(),
                dailyLimits.getKcalDemandPerDay(),
                dailyLimits.getDrinkDemandPerDay());
    }

    DailyLimits mappingAccountEntityToDailyLimits(AccountEntity accountEntity){
        return new DailyLimits(
                accountEntity.getKcalDemandPerDay(),
                accountEntity.getDrinkDemandPerDay()
        );
    }

}
