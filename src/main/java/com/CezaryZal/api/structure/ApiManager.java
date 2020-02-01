package com.CezaryZal.api.structure;

import com.CezaryZal.api.body.model.BodySizeDto;

public abstract class ApiManager {
    protected ApiConverter apiConverter;
    protected ApiCreator apiCreator;

    public abstract FormEntityDto convertDtoByEntity(FormEntity formEntity);

    public abstract FormEntity createNewEntityByEntityDto(FormEntityDto formEntityDto);

    public FormEntity createEntityToUpdateByEntityDto(BodySizeDto bodySizeDto, Long id){
        return apiCreator.createEntityToUpdate(bodySizeDto, id);
    }
}
