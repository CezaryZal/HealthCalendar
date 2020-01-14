package com.CezaryZal.api.body.manager.mapper;

import com.CezaryZal.api.body.entity.BodySize;
import com.CezaryZal.api.body.entity.BodySizeDto;
import org.springframework.stereotype.Service;

@Service
public class ConverterBodySizeToDto {

    public BodySizeDto mappingEntity(BodySize bodySize){
        return new BodySizeDto(
                bodySize.getId(),
                bodySize.getBodyWeight(),
                bodySize.getNeckSize(),
                bodySize.getArmSize(),
                bodySize.getBustSize(),
                bodySize.getWaist(),
                bodySize.getHipsSize(),
                bodySize.getFemoralSize(),
                bodySize.getCalf(),
                bodySize.getDateMeasurement(),
                bodySize.getUserId()
                );
    }

}
