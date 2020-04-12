package com.CezaryZal.api;

public interface ApiEntityServiceValidator {

    void validationModelDtoBeforeSaveOrUpdate(ApiEntityDto apiEntityDto, Long id);
}
