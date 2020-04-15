package com.CezaryZal.api;

import java.util.List;

public interface ApiEntityConverter {

    ApiEntityDto mappingApiEntityToDto(ApiEntity apiEntity);

    List<ApiEntityDto> mappingListApiEntityToListDto(List<ApiEntity> apiEntities);
}
