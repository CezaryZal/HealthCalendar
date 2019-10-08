package com.CezaryZal.bodySize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Transactional
@Service
public class BodySizeService {

    private BodySizeRepository bodyRepository;

    @Autowired
    public BodySizeService(BodySizeRepository bodyRepository) {
        this.bodyRepository = bodyRepository;
    }

    public BodySize bodySize(int id){
        return bodyRepository.getBodySize(id);
    }

    public BodySize getBodySizeByDateAndUserId (int userId, String inputDate){
        LocalDate tmpDate = LocalDate.parse(inputDate);

        BodySize newBodySize = new BodySize(75, 1, 5, 4, 60, 80,
                45, 6, LocalDate.of(2018, 5, 22), 1);
        newBodySize.setId(0);
        bodyRepository.saveBodySize(newBodySize);

        return bodyRepository.getBodySizeByDateAndUserId(userId, tmpDate);
    }
}
