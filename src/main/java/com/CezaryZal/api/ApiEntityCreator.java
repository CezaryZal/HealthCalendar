package com.CezaryZal.api;

public interface ApiEntityCreator {

    ApiEntity createApiEntityToUpdateByDtoAndApiEntityId(ApiEntityDto apiEntityDto);

    ApiEntity createApiEntityByDtoAndApiEntityId(ApiEntityDto apiEntityDto);
}
