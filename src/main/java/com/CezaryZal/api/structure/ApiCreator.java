package com.CezaryZal.api.structure;

import com.CezaryZal.api.body.model.BodySizeDto;

public interface ApiCreator {

    FormEntity createNewEntity(FormEntityDto formEntityDto);

    FormEntity createEntityToUpdate(BodySizeDto bodySizeDto, Long id);
}
