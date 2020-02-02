package com.CezaryZal.api.body.manager;

import com.CezaryZal.api.body.model.BodySizeDto;
import com.CezaryZal.api.body.model.entity.BodySize;
import com.CezaryZal.api.structure.ApiConverter;
import com.CezaryZal.api.structure.models.FormEntity;
import com.CezaryZal.api.structure.models.FormEntityDto;
import org.springframework.stereotype.Service;

@Service
public class BodySizeConverter implements ApiConverter {

    @Override
    public FormEntityDto convert(FormEntity formEntity) {
        BodySize bodySize = (BodySize) formEntity;
        return BodySizeDto.builder()
                .id(((BodySize) formEntity).getId())
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
