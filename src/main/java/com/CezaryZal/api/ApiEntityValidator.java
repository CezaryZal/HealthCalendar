package com.CezaryZal.api;

public interface ApiEntityValidator {

    void validationModelDtoBeforeSaveOrUpdate(ApiEntityDto apiEntityDto, Long id);
}
