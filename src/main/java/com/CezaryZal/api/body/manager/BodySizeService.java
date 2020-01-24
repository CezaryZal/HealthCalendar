package com.CezaryZal.api.body.manager;

import com.CezaryZal.api.body.model.FormBodySize;
import com.CezaryZal.api.body.model.entity.BodySize;
import com.CezaryZal.api.body.model.BodySizeDto;
import com.CezaryZal.api.body.manager.mapper.BodySizeConverter;
import com.CezaryZal.api.body.manager.repo.BodySizeRepoService;
import com.CezaryZal.exceptions.not.found.DateNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BodySizeService {

    private final BodySizeRepoService bodySizeRepoService;
    private final BodySizeConverter bodySizeConverter;

    @Autowired
    public BodySizeService(BodySizeRepoService bodySizeRepoService, BodySizeConverter bodySizeConverter) {
        this.bodySizeRepoService = bodySizeRepoService;
        this.bodySizeConverter = bodySizeConverter;
    }

    public FormBodySize getBodySizeDtoById(Long id) {
        return bodySizeConverter.mappingBodySizeToDto(bodySizeRepoService.getBodyById(id));
    }

    public LocalDate getDateLastMeasureByUserIdForBSController(Long userId) {
        return bodySizeRepoService.getDateLastMeasureByUserId(userId)
                .orElseThrow(() -> new DateNotFoundException("Date not found by user id"));
    }

    public FormBodySize getBodyDtoByDateAndUserId(String inputDate, Long userId) {
        return bodySizeConverter.mappingBodySizeToDto(
                bodySizeRepoService.getBodyByDateAndUserId(inputDate, userId));
    }

    public List<FormBodySize> getListBodySizeDto() {
        List<BodySize> allBodySize = bodySizeRepoService.getAll();
        return allBodySize.stream()
                .map(bodySizeConverter::mappingBodySizeToDto)
                .collect(Collectors.toList());
    }

    public String addBodySizeByDto(BodySizeDto bodySizeDto) {
        bodySizeRepoService.addBody(bodySizeConverter.mappingDtoToBodySize(bodySizeDto));
        return "Przesłany pomiar ciała został zapisany w bazie danych";
    }

    public String updateBodySizeByDto(BodySizeDto bodySizeDto){
        bodySizeRepoService.updateBody(bodySizeConverter.mappingDtoToBodySize(bodySizeDto));
        return "Przesłany pomiar został uaktualniony";
    }

    public String deleteBodySizeById(Long id){
        bodySizeRepoService.deleteBodyById(id);
        return "Pomiar ciała o przesłanym id został usunięty";
    }
}
