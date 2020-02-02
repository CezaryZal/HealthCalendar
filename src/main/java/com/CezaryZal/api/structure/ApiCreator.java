package com.CezaryZal.api.structure;

import com.CezaryZal.api.body.model.BodySizeDto;
import com.CezaryZal.api.structure.models.FormEntity;
import com.CezaryZal.api.structure.models.FormEntityDto;

public interface ApiCreator {

    FormEntity createNewEntity(FormEntityDto formEntityDto);

    FormEntity createEntityToUpdate(BodySizeDto bodySizeDto, Long id);
}
