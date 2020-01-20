package com.CezaryZal.api.body.manager.repo;

import com.CezaryZal.api.body.BodySizeRepository;
import com.CezaryZal.api.body.entity.BodySize;
import com.CezaryZal.exceptions.not.found.BodySizeNotFoundException;
import com.CezaryZal.exceptions.not.found.DateNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BodySizeRepoService {

    private final BodySizeRepository bodySizeR;

    @Autowired
    public BodySizeRepoService(BodySizeRepository BSRepository) {
        this.bodySizeR = BSRepository;
    }

    public BodySize getBodyById(Long id) {
        return bodySizeR.findById(id)
                .orElseThrow(() -> new BodySizeNotFoundException("Body size not found by id"));
    }

    public LocalDate getDateLastMeasureByUserId(Long userId) {
        Date tmpDate = bodySizeR.findDateLastMeasureByUserId(userId);
        return tmpDate == null ? null : tmpDate.toLocalDate();
    }

    public Long getDayIdByDateAndUserId(String inputDate, Long userId) {
        return bodySizeR.getDayIdByDateAndUserId(LocalDate.parse(inputDate), userId)
                .orElseThrow(() -> new DateNotFoundException("Date not found by date and user id"));
    }

    public List<LocalDate> getListDatesByUserId(Long userId) {
        List<Date> listDateByUserId = bodySizeR.findByUserIdAllDate(userId);
        return listDateByUserId.stream()
                .map(Date::toLocalDate)
                .collect(Collectors.toList());
    }

    public BodySize getBodyByDateAndUserId(String inputDate, Long userId) {
        return bodySizeR.findByDateMeasurementAndUserId(LocalDate.parse(inputDate), userId)
                .orElseThrow(() -> new BodySizeNotFoundException("Body size not found by user id and date"));
    }

    public List<BodySize> getAll() {
        return bodySizeR.findAll();
    }

    public void addBody(BodySize bodySize) {
        bodySizeR.save(bodySize);
    }

    public void updateBody(BodySize bodySize) {
        bodySizeR.save(bodySize);
    }

    public void deleteBodyById(Long id) {
        bodySizeR.deleteById(id);
    }
}
