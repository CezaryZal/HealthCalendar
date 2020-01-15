package com.CezaryZal.api.body.manager;

import com.CezaryZal.api.body.BodySizeRepository;
import com.CezaryZal.api.body.entity.BodySize;
import com.CezaryZal.api.body.entity.BodySizeDto;
import com.CezaryZal.api.body.manager.mapper.ConverterBodySizeToDto;
import com.CezaryZal.api.body.manager.mapper.ConverterDtoToBodySize;
import com.CezaryZal.api.body.manager.repo.BodySizeRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BodySizeService extends BodySizeRepoService {

    private final ConverterBodySizeToDto converterBodySizeToDto;
    private final ConverterDtoToBodySize converterDtoToBodySize;

    @Autowired
    public BodySizeService(BodySizeRepository BSRepository,
                           ConverterBodySizeToDto converterBodySizeToDto,
                           ConverterDtoToBodySize converterDtoToBodySize) {
        super(BSRepository);
        this.converterBodySizeToDto = converterBodySizeToDto;
        this.converterDtoToBodySize = converterDtoToBodySize;
    }

    public BodySizeDto getBodySizeDtoById(Long id) {
        return converterBodySizeToDto.mappingEntity(getBodyById(id));
    }

    public BodySizeDto getBodyDtoByDateAndUserId(String inputDate, Long userId) {
        return converterBodySizeToDto.mappingEntity(getBodyByDateAndUserId(inputDate, userId));
    }

    public List<BodySizeDto> getListBodySizeDto() {
        List<BodySize> allBodySize = getAll();
        return allBodySize.stream()
                .map(converterBodySizeToDto::mappingEntity)
                .collect(Collectors.toList());
    }

    public String addBodySizeByDao(BodySizeDto bodySizeDto) {
        addBody(converterDtoToBodySize.mappingEntity(bodySizeDto));
        return "Przesłany pomiar ciała został zapisany w bazie danych";
    }

    public String updateBodySizeByDao(BodySizeDto bodySizeDto){
        updateBody(converterDtoToBodySize.mappingEntity(bodySizeDto));
        return "Przesłany pomiar został uaktualniony";
    }

    public String deleteBodySizeById(Long id){
        deleteBodyById(id);
        return "Pomiar ciała o przesłanym id został usunięty";
    }
}
