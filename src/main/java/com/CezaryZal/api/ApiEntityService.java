package com.CezaryZal.api;

import java.util.List;

public interface ApiEntityService {

    ApiEntityDto getModelDtoByModelId(Long id);

    List<ApiEntityDto> getModelsDtoByModelId();

    String addModelByDtoAndUserId(ApiEntityDto apiEntityDto, Long userId);

    String updateModelByDtoAndUserId(ApiEntityDto apiEntityDto, Long userId);

    String deleteByModelIdAndUserId(Long modelId, Long userId);
}
