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

        return BSRepository.findById(id);
    }

    public BodySize findByDateAndUserId(String inputDate, int userId){
        LocalDate localDate = LocalDate.parse(inputDate);

        return BSRepository.findByDateAndUserId(localDate, userId);
    }

    public List<BodySize> getAll(){
        return BSRepository.getAll();
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
