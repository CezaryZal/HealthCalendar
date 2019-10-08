package com.CezaryZal.bodySize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;


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

    public Boolean addBody (BodySize bodySize){
        BodySize bodySize1 = new BodySize(1, 2, 3, 4, 5, 6, 7,
                8, LocalDate.of(2018,6,13), 9);
        bodySize1.setId(0);
        BSRepository.save(bodySize1);

        return true;
    }
}
