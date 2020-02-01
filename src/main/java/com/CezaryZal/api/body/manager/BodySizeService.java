package com.CezaryZal.api.body.manager;

import com.CezaryZal.api.body.model.entity.BodySize;
import com.CezaryZal.api.body.model.BodySizeDto;
import com.CezaryZal.api.body.repo.BodySizeRepository;
import com.CezaryZal.api.structure.ApiManager;
import com.CezaryZal.api.structure.FormEntityDto;
import com.CezaryZal.exceptions.not.found.BodySizeNotFoundException;
import com.CezaryZal.exceptions.not.found.DateNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BodySizeService {

    private final BodySizeRepository bodySizeRepository;
    private final ApiManager apiManager;

    @Autowired
    public BodySizeService(BodySizeRepository bodySizeRepository) {
        this.bodySizeRepository = bodySizeRepository;
        this.apiManager = new BodySizeManager();
    }

    public FormEntityDto getBodySizeDtoById(Long id) {
        BodySize bodySize = bodySizeRepository.findById(id)
                .orElseThrow(() -> new BodySizeNotFoundException("Body size not found by id"));
        FormEntityDto bodySizeDto = apiManager.convertDtoByEntity(bodySize);
        return bodySizeDto;
    }

    public LocalDate getDateLastMeasureByUserIdForBSController(Long userId) {
        return getDateLastMeasureByUserId(userId)
                .orElseThrow(() -> new DateNotFoundException("Date not found by user id"));
    }

    public Optional<LocalDate> getDateLastMeasureByUserId(Long userId) {
        return bodySizeRepository.findDateLastMeasureByUserId(userId)
                .map(Date::toLocalDate);
    }

    public FormEntityDto getBodyDtoByDateAndUserId(String inputDate, Long userId) {
        BodySize bodySize = bodySizeRepository.findByDateMeasurementAndUserId(LocalDate.parse(inputDate), userId)
                .orElseThrow(() -> new BodySizeNotFoundException("Body size not found by user id and date"));
        return apiManager.convertDtoByEntity(bodySize);
    }

    public List<LocalDate> getListDatesByUserId(Long userId) {
        List<Date> listDateByUserId = bodySizeRepository.findByUserIdAllDate(userId)
                .orElseThrow(() -> new BodySizeNotFoundException("Is user didn't take measurements"));
        return listDateByUserId.stream()
                .map(Date::toLocalDate)
                .collect(Collectors.toList());
    }

    public List<FormEntityDto> getListBodySizeDto() {
        List<BodySize> allBodySize = bodySizeRepository.findAll();
        return allBodySize.stream()
                .map(apiManager::convertDtoByEntity)
                .collect(Collectors.toList());
    }

    public String addBodySizeByDto(BodySizeDto bodySizeDto) {
        bodySizeRepository.save((BodySize) apiManager.createNewEntityByEntityDto(bodySizeDto));
        return "Przesłany pomiar ciała został zapisany w bazie danych";
    }

    public String updateBodySizeByDto(BodySizeDto bodySizeDto, Long id){
        bodySizeRepository.save((BodySize) apiManager.createEntityToUpdateByEntityDto(bodySizeDto, id));
        return "Przesłany pomiar został uaktualniony";
    }

    public String deleteBodySizeById(Long id){
        bodySizeRepository.deleteById(id);
        return "Pomiar ciała o przesłanym id został usunięty";
    }
}
