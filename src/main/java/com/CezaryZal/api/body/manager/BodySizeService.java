package com.CezaryZal.api.body.manager;

import com.CezaryZal.api.body.model.entity.BodySize;
import com.CezaryZal.api.body.model.BodySizeDto;
import com.CezaryZal.api.body.repo.BodySizeRepository;
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
    private final BodySizeConverter bodySizeConverter;
    private final BodySizeCreator bodySizeCreator;

    @Autowired
    public BodySizeService(BodySizeRepository bodySizeRepository,
                           BodySizeConverter bodySizeConverter,
                           BodySizeCreator bodySizeCreator) {
        this.bodySizeRepository = bodySizeRepository;
        this.bodySizeConverter = bodySizeConverter;
        this.bodySizeCreator = bodySizeCreator;
    }

    public BodySizeDto getBodySizeDtoById(Long id) {
        BodySize bodySize = bodySizeRepository.findById(id)
                .orElseThrow(() -> new BodySizeNotFoundException("Body size not found by id"));
        return bodySizeConverter.mappingBodySizeToDto(bodySize);
    }

    public LocalDate getDateLastMeasureByUserIdForBSController(Long userId) {
        return getDateOfLastMeasureByUserId(userId)
                .orElseThrow(() -> new DateNotFoundException("Date not found by user id"));
    }

    public Optional<LocalDate> getDateOfLastMeasureByUserId(Long userId) {
        return bodySizeRepository.findDateOfLastMeasureByUserId(userId)
                .map(Date::toLocalDate);
    }

    public BodySizeDto getBodyDtoByDateAndUserId(String inputDate, Long userId) {
        BodySize bodySize = bodySizeRepository.findByDateMeasurementAndUserId(LocalDate.parse(inputDate), userId)
                .orElseThrow(() -> new BodySizeNotFoundException("Body size not found by user id and date"));
        return bodySizeConverter.mappingBodySizeToDto(bodySize);
    }

    public List<LocalDate> getListDatesByUserId(Long userId) {
        List<Date> listDateByUserId = bodySizeRepository.findByUserIdAllDate(userId)
                .orElseThrow(() -> new BodySizeNotFoundException("The user has not taken measurements"));
        return listDateByUserId.stream()
                .map(Date::toLocalDate)
                .collect(Collectors.toList());
    }

    public List<BodySizeDto> getListBodySizeDtoByUserId(Long userId){
        List<BodySize> allBodySizeByUserId = bodySizeRepository.findAllByUserId(userId);
        return allBodySizeByUserId.stream()
                .map(bodySizeConverter::mappingBodySizeToDto)
                .collect(Collectors.toList());
    }

    public List<BodySizeDto> getListBodySizeDto() {
        List<BodySize> allBodySize = bodySizeRepository.findAll();
        return allBodySize.stream()
                .map(bodySizeConverter::mappingBodySizeToDto)
                .collect(Collectors.toList());
    }

    public String addBodySizeByDto(BodySizeDto bodySizeDto) {
        bodySizeRepository.save(bodySizeCreator.createBodySizeByDtoAndBodyId(bodySizeDto));
        return "Received the body measurement has been saved to the database";
    }

    public String updateBodySizeByDto(BodySizeDto bodySizeDto, Long id){
        bodySizeRepository.save(bodySizeCreator.createBodySizeToUpdateByDtoAndBodyId(bodySizeDto, id));
        return "Received the body measurement has been updated";
    }

    public String deleteBodySizeById(Long id){
        bodySizeRepository.deleteById(id);
        return "The body measurement has been removed based on Id";
    }
}
