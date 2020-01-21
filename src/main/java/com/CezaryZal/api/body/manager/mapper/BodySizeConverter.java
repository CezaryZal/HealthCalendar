package com.CezaryZal.api.body.manager.mapper;

import com.CezaryZal.api.body.model.entity.BodySize;
import com.CezaryZal.api.body.model.BodySizeDto;
import org.springframework.stereotype.Service;

@Service
public class BodySizeConverter {

    public BodySizeDto mappingBodySizeToDto(BodySize bodySize){
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

    public BodySize mappingDtoToBodySize(BodySizeDto bodySizeDto){
        return new BodySize(
                bodySizeDto.getId(),
                bodySizeDto.getBodyWeight(),
                bodySizeDto.getNeckSize(),
                bodySizeDto.getArmSize(),
                bodySizeDto.getBustSize(),
                bodySizeDto.getWaist(),
                bodySizeDto.getHipsSize(),
                bodySizeDto.getFemoralSize(),
                bodySizeDto.getCalf(),
                bodySizeDto.getDateMeasurement(),
                bodySizeDto.getUserId());

    }

}
