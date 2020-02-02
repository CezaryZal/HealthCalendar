package com.CezaryZal.api.structure;

import com.CezaryZal.api.body.model.BodySizeDto;
import com.CezaryZal.api.structure.models.FormEntity;
import com.CezaryZal.api.structure.models.FormEntityDto;

public abstract class ApiManager {
    protected ApiConverter apiConverter;
    protected ApiCreator apiCreator;

    protected abstract FormEntityDto convertDtoByEntity(FormEntity formEntity);

    protected abstract FormEntity createNewEntityByEntityDto(FormEntityDto formEntityDto);

    public FormEntity createEntityToUpdateByEntityDto(BodySizeDto bodySizeDto, Long id){
        return apiCreator.createEntityToUpdate(bodySizeDto, id);
    }
}
