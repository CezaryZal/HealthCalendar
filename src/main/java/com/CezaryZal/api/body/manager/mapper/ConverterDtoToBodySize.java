package com.CezaryZal.api.body.manager.mapper;

import com.CezaryZal.api.body.entity.BodySize;
import com.CezaryZal.api.body.entity.BodySizeDto;
import org.springframework.stereotype.Service;


@Service
public class ConverterDtoToBodySize {

    public BodySize mappingEntity(BodySizeDto bodySizeDto){
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
