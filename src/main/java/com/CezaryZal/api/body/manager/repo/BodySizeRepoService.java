package com.CezaryZal.api.body.manager.repo;

import com.CezaryZal.api.body.BodySizeRepository;
import com.CezaryZal.api.body.entity.BodySize;
import com.CezaryZal.exceptions.BodySizeNotFoundException;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BodySizeRepoService {

    private BodySizeRepository bodySizeR;

    public BodySizeRepoService(BodySizeRepository BSRepository) {
        this.bodySizeR = BSRepository;
    }

    public BodySize getBodyById(Long id) {
        return bodySizeR.findById(id)
                .orElseThrow(() -> new BodySizeNotFoundException("Body size not found by id"));
    }

    public LocalDate getDateLastMeasureByUserId(Long userId) {
        Date tmpDate = bodySizeR.findDateLastMeasureByUserId(userId)
                .orElseThrow(() -> new BodySizeNotFoundException("Body size not found by user id"));
        return tmpDate.toLocalDate();
    }

    public List<LocalDate> getListDatesByUserId(Long userId) {
        List<Date> listDateByUserId = bodySizeR.findByUserIdAllDate(userId);
        List<LocalDate> listLocalDateByUserId = new ArrayList<>();
        listDateByUserId.forEach(tmpDate -> listLocalDateByUserId.add(tmpDate.toLocalDate()));

        return listLocalDateByUserId;
    }

    public BodySize getBodyByDateAndUserId(String inputDate, Long userId) {
        return bodySizeR.findByDateMeasurementAndUserId(LocalDate.parse(inputDate), userId)
                .orElseThrow(() -> new BodySizeNotFoundException("Body size not found by user id and date"));
    }

    public List<BodySize> getAll() {
        return (List<BodySize>) bodySizeR.findAll();
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
