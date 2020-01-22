package com.CezaryZal.api.body.manager.mapper;

import com.CezaryZal.api.body.model.FormBodySize;
import com.CezaryZal.api.body.model.entity.BodySize;
import com.CezaryZal.api.body.model.BodySizeDto;
import org.springframework.stereotype.Service;

@Service
public class BodySizeConverter {

    public FormBodySize mappingBodySizeToDto(BodySize bodySize){
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
                .build();
    }

    public BodySize mappingDtoToBodySize(BodySizeDto bodySizeDto){
        return BodySize.Builder.builder()
                .id(bodySizeDto.getId())
                .bodyWeight(bodySizeDto.getBodyWeight())
                .neckSize(bodySizeDto.getNeckSize())
                .armSize(bodySizeDto.getArmSize())
                .bustSize(bodySizeDto.getBustSize())
                .waist(bodySizeDto.getWaist())
                .hipsSize(bodySizeDto.getHipsSize())
                .femoralSize(bodySizeDto.getFemoralSize())
                .calf(bodySizeDto.getCalf())
                .dateMeasurement(bodySizeDto.getDateMeasurement())
                .userId(bodySizeDto.getUserId())
                .build();

    }

}
