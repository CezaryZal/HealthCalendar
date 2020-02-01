package com.CezaryZal.api.body.manager;

import com.CezaryZal.api.body.model.BodySizeDto;
import com.CezaryZal.api.body.model.entity.BodySize;
import org.springframework.stereotype.Service;

@Service
public class BodySizeCreator {

    BodySize createBodySizeToUpdateByDtoAndBodyId(BodySizeDto bodySizeDto, Long id){
        BodySize.Builder builder = mappingDtoToBodySizeBuilder(bodySizeDto);
        return builder
                .id(id)
                .build();
    }

    BodySize createBodySizeByDtoAndBodyId(BodySizeDto bodySizeDto){
        return mappingDtoToBodySizeBuilder(bodySizeDto).build();
    }

    private BodySize.Builder mappingDtoToBodySizeBuilder(BodySizeDto bodySizeDto){
        return BodySize.builder()
                .bodyWeight(bodySizeDto.getBodyWeight())
                .neckSize(bodySizeDto.getNeckSize())
                .armSize(bodySizeDto.getArmSize())
                .bustSize(bodySizeDto.getBustSize())
                .waist(bodySizeDto.getWaist())
                .hipsSize(bodySizeDto.getHipsSize())
                .femoralSize(bodySizeDto.getFemoralSize())
                .calf(bodySizeDto.getCalf())
                .dateMeasurement(bodySizeDto.getDateMeasurement())
                .userId(bodySizeDto.getUserId());
    }
}
