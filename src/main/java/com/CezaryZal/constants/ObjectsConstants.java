package com.CezaryZal.constants;

import com.CezaryZal.api.limits.model.LimitsCleanDate;
import org.springframework.stereotype.Component;

@Component
public class ObjectsConstants {

    public LimitsCleanDate getLimitsCleanDateWithFinalArgs(){
        return new LimitsCleanDate(10000, 100);
    }
}
