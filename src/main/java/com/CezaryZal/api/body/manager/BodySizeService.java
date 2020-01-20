package com.CezaryZal.api.body.manager;

import com.CezaryZal.api.body.entity.BodySize;
import com.CezaryZal.api.body.entity.BodySizeDto;
import com.CezaryZal.api.body.manager.mapper.BodySizeToDtoConverter;
import com.CezaryZal.api.body.manager.mapper.DtoToBodySizeConverter;
import com.CezaryZal.api.body.manager.repo.BodySizeRepoService;
import com.CezaryZal.exceptions.not.found.DateNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BodySizeService {

    private final BodySizeRepoService bodySizeRepoService;
    private final BodySizeToDtoConverter bodySizeToDtoConverter;
    private final DtoToBodySizeConverter dtoToBodySizeConverter;

    @Autowired
    public BodySizeService(BodySizeRepoService bodySizeRepoService,
                           BodySizeToDtoConverter bodySizeToDtoConverter,
                           DtoToBodySizeConverter dtoToBodySizeConverter) {
        this.bodySizeRepoService = bodySizeRepoService;
        this.bodySizeToDtoConverter = bodySizeToDtoConverter;
        this.dtoToBodySizeConverter = dtoToBodySizeConverter;
    }

    public BodySizeDto getBodySizeDtoById(Long id) {
        return bodySizeToDtoConverter.mappingEntity(bodySizeRepoService.getBodyById(id));
    }

    public LocalDate getDateLastMeasureByUserIdForBSController(Long userId) {
        Optional<LocalDate> optionalDateLastMeasure =
                Optional.ofNullable(bodySizeRepoService.getDateLastMeasureByUserId(userId));
        return optionalDateLastMeasure
                .orElseThrow(() -> new DateNotFoundException("Date not found by user id"));
    }

    public BodySizeDto getBodyDtoByDateAndUserId(String inputDate, Long userId) {
        return bodySizeToDtoConverter.mappingEntity(
                bodySizeRepoService.getBodyByDateAndUserId(inputDate, userId));
    }

    public List<BodySizeDto> getListBodySizeDto() {
        List<BodySize> allBodySize = bodySizeRepoService.getAll();
        return allBodySize.stream()
                .map(bodySizeToDtoConverter::mappingEntity)
                .collect(Collectors.toList());
    }

    public String addBodySizeByDto(BodySizeDto bodySizeDto) {
        bodySizeRepoService.addBody(dtoToBodySizeConverter.mappingEntity(bodySizeDto));
        return "Przesłany pomiar ciała został zapisany w bazie danych";
    }

    public String updateBodySizeByDto(BodySizeDto bodySizeDto){
        bodySizeRepoService.updateBody(dtoToBodySizeConverter.mappingEntity(bodySizeDto));
        return "Przesłany pomiar został uaktualniony";
    }

    public String deleteBodySizeById(Long id){
        bodySizeRepoService.deleteBodyById(id);
        return "Pomiar ciała o przesłanym id został usunięty";
    }
}
