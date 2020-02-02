package com.CezaryZal.api.structure;

import com.CezaryZal.api.structure.models.FormEntity;
import com.CezaryZal.api.structure.models.FormEntityDto;

public abstract class ApiManager {
    protected ApiConverter apiConverter;
    protected ApiCreator apiCreator;

    protected FormEntityDto convertDtoByEntity(FormEntity formEntity){
        return apiConverter.convertDtoByEntity(formEntity);
    }

    protected FormEntity createNewEntityByEntityDto(FormEntityDto formEntityDto){
        return apiCreator.createNewEntity(formEntityDto);
    }

    public FormEntity createEntityToUpdateByEntityDto(FormEntityDto formEntityDto, Long id){
        return apiCreator.createEntityToUpdate(formEntityDto, id);
    }
}
