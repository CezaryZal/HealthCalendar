package com.CezaryZal.bodySize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
