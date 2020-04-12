package com.CezaryZal.validation.validator;

import com.CezaryZal.api.ApiEntityDto;

public interface ModelServiceValidator {

    void validationModelDtoBeforeSaveOrUpdate(ApiEntityDto apiEntityDto, Long id);
}
