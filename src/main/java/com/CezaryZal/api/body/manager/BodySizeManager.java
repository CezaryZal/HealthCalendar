package com.CezaryZal.api.body.manager;

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
    protected FormEntityDto convertDtoByEntity(FormEntity formEntity) {
        return apiConverter.convert(formEntity);
    }

    @Override
    protected FormEntity createNewEntityByEntityDto(FormEntityDto formEntityDto) {
        return apiCreator.createNewEntity(formEntityDto);
    }
}
