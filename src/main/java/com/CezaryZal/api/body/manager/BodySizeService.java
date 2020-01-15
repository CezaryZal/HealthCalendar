package com.CezaryZal.api.body.manager;

import com.CezaryZal.api.body.BodySizeRepository;
import com.CezaryZal.api.body.entity.BodySize;
import com.CezaryZal.api.body.entity.BodySizeDto;
import com.CezaryZal.api.body.manager.mapper.BodySizeToDtoConverter;
import com.CezaryZal.api.body.manager.mapper.DtoToBodySizeConverter;
import com.CezaryZal.api.body.manager.repo.BodySizeRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BodySizeService extends BodySizeRepoService {

    private final BodySizeToDtoConverter bodySizeToDtoConverter;
    private final DtoToBodySizeConverter dtoToBodySizeConverter;

    @Autowired
    public BodySizeService(BodySizeRepository BSRepository,
                           BodySizeToDtoConverter bodySizeToDtoConverter,
                           DtoToBodySizeConverter dtoToBodySizeConverter) {
        super(BSRepository);
        this.bodySizeToDtoConverter = bodySizeToDtoConverter;
        this.dtoToBodySizeConverter = dtoToBodySizeConverter;
    }

    public BodySizeDto getBodySizeDtoById(Long id) {
        return bodySizeToDtoConverter.mappingEntity(getBodyById(id));
    }

    public BodySizeDto getBodyDtoByDateAndUserId(String inputDate, Long userId) {
        return bodySizeToDtoConverter.mappingEntity(getBodyByDateAndUserId(inputDate, userId));
    }

    public List<BodySizeDto> getListBodySizeDto() {
        List<BodySize> allBodySize = getAll();
        return allBodySize.stream()
                .map(bodySizeToDtoConverter::mappingEntity)
                .collect(Collectors.toList());
    }

    public String addBodySizeByDao(BodySizeDto bodySizeDto) {
        addBody(dtoToBodySizeConverter.mappingEntity(bodySizeDto));
        return "Przesłany pomiar ciała został zapisany w bazie danych";
    }

    public String updateBodySizeByDao(BodySizeDto bodySizeDto){
        updateBody(dtoToBodySizeConverter.mappingEntity(bodySizeDto));
        return "Przesłany pomiar został uaktualniony";
    }

    public String deleteBodySizeById(Long id){
        deleteBodyById(id);
        return "Pomiar ciała o przesłanym id został usunięty";
    }
}
