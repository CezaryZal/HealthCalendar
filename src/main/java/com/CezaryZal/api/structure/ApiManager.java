package com.CezaryZal.api.structure;

import com.CezaryZal.api.body.model.BodySizeDto;

public abstract class ApiManager {
    public ApiConverter apiConverter;
    public ApiCreator apiCreator;

    public abstract FormEntityDto convertDtoByEntity(FormEntity formEntity);

    public abstract FormEntity createNewEntityByEntityDto(FormEntityDto formEntityDto);

    public FormEntity createEntityToUpdateByEntityDto(BodySizeDto bodySizeDto, Long id){
        return apiCreator.createEntityToUpdate(bodySizeDto, id);
    }
}
