package com.CezaryZal.bodySize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;


//@Transactional
@Service
public class BodySizeService {

    private BodySizeRepository BodySizeR;

    @Autowired
    public BodySizeService(BodySizeRepository BSRepository) {
        this.BodySizeR = BSRepository;
    }

    public BodySize getBodyById (int id){
        return BodySizeR.findById(id);
    }

    public LocalDate getDateLastMeasureByUserId (int userId){
        return BodySizeR.findDateLastMeasureByUserId(userId);
    }

    public List<LocalDate> getListDatesByUserIdAllDate(int userId) {
        return BodySizeR.findByUserIdAllDate(userId);

    }

    public BodySize getBodyByDateAndUserId(String inputDate, int userId){
        return BodySizeR.findByDateAndUserId(LocalDate.parse(inputDate), userId);
    }

    public List<BodySize> getAll(){
        return BodySizeR.getAll();
    }

    public boolean addBody (BodySize bodySize){
        BodySizeR.save(bodySize);

        return true;
    }

    public String deleteBodyById (int id) {
        BodySize bodySize = BodySizeR.findById(id);
        if (BodySizeR.delete(bodySize)){
            return "delete record";
        }
        return "Body size id not found";
    }
}
