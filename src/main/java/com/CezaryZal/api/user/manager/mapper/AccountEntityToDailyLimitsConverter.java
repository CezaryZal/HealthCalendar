package com.CezaryZal.api.user.manager.mapper;

import com.CezaryZal.api.limits.entity.DailyLimits;
import com.CezaryZal.api.user.entity.AccountEntity;
import org.springframework.stereotype.Service;

@Service
public class AccountEntityToDailyLimitsConverter {

    public DailyLimits mappingEntity(AccountEntity accountEntity){
        return new DailyLimits(
                accountEntity.getKcalDemandPerDay(),
                accountEntity.getDrinkDemandPerDay()
        );
    }
}
