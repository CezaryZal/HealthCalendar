package com.CezaryZal.api.body.manager;

import com.CezaryZal.api.body.model.BodySizeDto;
import com.CezaryZal.api.body.model.entity.BodySize;
import com.CezaryZal.api.structure.ApiManager;
import com.CezaryZal.api.structure.models.FormEntity;
import com.CezaryZal.api.structure.models.FormEntityDto;
import org.springframework.stereotype.Service;

@Service
public class BodySizeManager extends ApiManager {

    public BodySizeManager() {
        apiConverter = new BodySizeConverter();
        apiCreator = new BodySizeCreator();
    }

    @Override
    protected BodySizeDto convertDtoByEntity(FormEntity formEntity) {
        return (BodySizeDto) apiConverter.convertDtoByEntity(formEntity);
    }

    @Override
    protected BodySize createNewEntityByEntityDto(FormEntityDto formEntityDto) {
        return (BodySize) apiCreator.createNewEntity(formEntityDto);
    }
}
