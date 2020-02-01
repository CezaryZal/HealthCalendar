package com.CezaryZal.api.body.manager;

import com.CezaryZal.api.structure.ApiManager;
import com.CezaryZal.api.structure.FormEntity;
import com.CezaryZal.api.structure.FormEntityDto;

public class BodySizeManager extends ApiManager {

    public BodySizeManager() {
        apiConverter = new BodySizeConverterTwo();
        apiCreator = new BodySizeCreatorTwo();
    }

    @Override
    public FormEntityDto convertDtoByEntity(FormEntity formEntity) {
        return apiConverter.convert(formEntity);
    }

    @Override
    public FormEntity createNewEntityByEntityDto(FormEntityDto formEntityDto) {
        return apiCreator.createNewEntity(formEntityDto);
    }
}
