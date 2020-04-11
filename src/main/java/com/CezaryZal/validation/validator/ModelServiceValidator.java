package com.CezaryZal.validation.validator;

import com.CezaryZal.api.ModelDto;

public interface ModelServiceValidator {

    void validationModelDtoBeforeSaveOrUpdate(ModelDto modelDto, Long id);
}
