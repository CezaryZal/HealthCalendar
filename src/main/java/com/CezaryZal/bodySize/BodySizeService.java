package com.CezaryZal.bodySize;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class BodySizeService {

    private BodySizeRepository BodySizeR;

    public BodySizeService(BodySizeRepository BSRepository) {
        this.BodySizeR = BSRepository;
    }

    public BodySize getBodyById (Long id){
        return BodySizeR.findById(id);
    }

    public LocalDate getDateLastMeasureByUserId (Long userId){
        return BodySizeR.findDateLastMeasureByUserId(userId);
    }

    public List<LocalDate> getListDatesByUserIdAllDate(Long userId) {
        return BodySizeR.findByUserIdAllDate(userId);

    }

    public BodySize getBodyByDateAndUserId(String inputDate, Long userId){
        return BodySizeR.findByDateAndUserId(LocalDate.parse(inputDate), userId);
    }

    public List<BodySize> getAll(){
        return BodySizeR.getAll();
    }

    public boolean addBody (BodySize bodySize){
        BodySizeR.save(bodySize);

        return true;
    }

    public String deleteBodyById (Long id) {
        BodySize bodySize = BodySizeR.findById(id);
        if (BodySizeR.delete(bodySize)){
            return "delete record";
        }
        return "Body size id not found";
    }
}
