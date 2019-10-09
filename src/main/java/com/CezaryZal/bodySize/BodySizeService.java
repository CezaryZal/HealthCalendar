package com.CezaryZal.bodySize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;


@Transactional
@Service
public class BodySizeService {

    private BodySizeRepository BSRepository;

    @Autowired
    public BodySizeService(BodySizeRepository BSRepository) {
        this.BSRepository = BSRepository;
    }

    public BodySize findById (int id){
        BodySize bodySize = BSRepository.findById(id);

        return bodySize;
    }

    public LocalDate findDateLastMeasureByUserId (int userId){
        LocalDate localDate = BSRepository.findDateLastMeasureByUserId(userId);

        return localDate;
    }

    public List<LocalDate> findByUserIdAllDate(int userId) {
        List<LocalDate> tmpList = BSRepository.findByUserIdAllDate(userId);

        return tmpList;
    }

    public BodySize findByDateAndUserId(String inputDate, int userId){
        LocalDate localDate = LocalDate.parse(inputDate);
        BodySize bodySize = BSRepository.findByDateAndUserId(localDate, userId);

        return bodySize;
    }

    public List<BodySize> getAll(){
        List<BodySize> listBody = BSRepository.getAll();

        return listBody;
    }

    public boolean addBody (BodySize bodySize){
        BSRepository.save(bodySize);

        return true;
    }

    public String delete (int id) {
        BodySize bodySize = BSRepository.findById(id);
        if (BSRepository.delete(bodySize)){
            return "delete record";
        }
        return "Body size id not found";
    }
}
