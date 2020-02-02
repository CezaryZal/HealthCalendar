package com.CezaryZal.api.body.manager;

import com.CezaryZal.api.body.model.BodySizeDto;
import com.CezaryZal.api.body.model.entity.BodySize;
import com.CezaryZal.api.structure.ApiCreator;
import com.CezaryZal.api.structure.models.FormEntity;
import com.CezaryZal.api.structure.models.FormEntityDto;

public class BodySizeCreator implements ApiCreator {


    @Override
    public FormEntity createNewEntity(FormEntityDto formEntityDto) {
        return mappingDtoToBodySizeBuilder(formEntityDto).build();
    }

    @Override
    public FormEntity createEntityToUpdate(FormEntityDto formEntityDto, Long id) {
        BodySize.Builder builder = mappingDtoToBodySizeBuilder(formEntityDto);
        return builder
                .id(id)
                .build();
    }

    private BodySize.Builder mappingDtoToBodySizeBuilder(FormEntityDto formEntityDto){
        BodySizeDto bodySizeDto = (BodySizeDto) formEntityDto;
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
