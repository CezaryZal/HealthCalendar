package com.CezaryZal.api.body.manager.mapper;

import com.CezaryZal.api.body.model.entity.BodySize;
import com.CezaryZal.api.body.model.BodySizeDto;
import org.springframework.stereotype.Service;

@Service
public class BodySizeConverter {

    public BodySizeDto mappingBodySizeToDto(BodySize bodySize){
        return BodySizeDto.Builder.builder()
                .id(bodySize.getId())
                .bodyWeight(bodySize.getBodyWeight())
                .neckSize(bodySize.getNeckSize())
                .armSize(bodySize.getArmSize())
                .bustSize(bodySize.getBustSize())
                .waist(bodySize.getWaist())
                .hipsSize(bodySize.getHipsSize())
                .femoralSize(bodySize.getFemoralSize())
                .calf(bodySize.getCalf())
                .dateMeasurement(bodySize.getDateMeasurement())
                .userId(bodySize.getUserId())
                .buildDto();
    }
}
