package com.CezaryZal.api.structure;

import com.CezaryZal.api.structure.models.FormEntity;
import com.CezaryZal.api.structure.models.FormEntityDto;

public interface ApiConverter {

    FormEntityDto convert(FormEntity formEntity);
}
