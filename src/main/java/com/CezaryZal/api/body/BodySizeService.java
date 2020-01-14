package com.CezaryZal.api.body;

import com.CezaryZal.exceptions.BodySizeNotFoundException;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BodySizeService {

    private BodySizeRepository BodySizeR;

    public BodySizeService(BodySizeRepository BSRepository) {
        this.BodySizeR = BSRepository;
    }

    public BodySize getBodyById(Long id) {
        return BodySizeR.findById(id)
                .orElseThrow(() -> new BodySizeNotFoundException("Body size not found by id"));
    }

    public LocalDate getDateLastMeasureByUserId(Long userId) {
        Date tmpDate = BodySizeR.findDateLastMeasureByUserId(userId)
                .orElseThrow(() -> new BodySizeNotFoundException("Body size not found by user id"));
        return tmpDate.toLocalDate();
    }

    public List<LocalDate> getListDatesByUserId(Long userId) {
        List<Date> listDateByUserId = BodySizeR.findByUserIdAllDate(userId);
        List<LocalDate> listLocalDateByUserId = new ArrayList<>();
        listDateByUserId.forEach( tmpDate -> listLocalDateByUserId.add(tmpDate.toLocalDate()));

        return listLocalDateByUserId;
    }

    public BodySize getBodyByDateAndUserId(String inputDate, Long userId) {
        return BodySizeR.findByDateMeasurementAndUserId(LocalDate.parse(inputDate), userId)
                .orElseThrow(() -> new BodySizeNotFoundException("Body size not found by user id and date"));
    }

    public List<BodySize> getAll() {
        return (List<BodySize>) BodySizeR.findAll();
    }

    public void addBody(BodySize bodySize) {
        BodySizeR.save(bodySize);
    }

    public void deleteBodyById(Long id) {
        BodySizeR.deleteById(id);
    }
}
