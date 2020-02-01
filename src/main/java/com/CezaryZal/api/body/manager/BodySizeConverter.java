package com.CezaryZal.api.body.manager;

import com.CezaryZal.api.body.model.entity.BodySize;
import com.CezaryZal.api.body.model.BodySizeDto;
import org.springframework.stereotype.Service;

@Service
public class BodySizeConverter {

    BodySizeDto mappingBodySizeToDto(BodySize bodySize){
        return BodySizeDto.builder()
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
