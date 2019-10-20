package com.CezaryZal.bodySize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;


@Transactional
@Service
public class BodySizeService {

    private BodySizeRepository BodySizeR;

    @Autowired
    public BodySizeService(BodySizeRepository BSRepository) {
        this.BodySizeR = BSRepository;
    }

    public BodySize getBodyById (int id){
        BodySize bodySize = BodySizeR.findById(id);

        return bodySize;
    }

    public LocalDate getDateLastMeasureByUserId (int userId){
        LocalDate localDate = BodySizeR.findDateLastMeasureByUserId(userId);

        return localDate;
    }

    public List<LocalDate> getListDatesByUserIdAllDate(int userId) {
        List<LocalDate> tmpList = BodySizeR.findByUserIdAllDate(userId);

        return tmpList;
    }

    public BodySize getBodyByDateAndUserId(String inputDate, int userId){
        BodySize bodySize = BodySizeR.findByDateAndUserId(LocalDate.parse(inputDate), userId);

        return bodySize;
    }

    public List<BodySize> getAll(){
        List<BodySize> listBody = BodySizeR.getAll();

        return listBody;
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
