package com.CezaryZal.bodySize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BodySizeService {

    private BodySizeRepository bodyRepository;

    @Autowired
    public BodySizeService(BodySizeRepository bodyRepository) {
        this.bodyRepository = bodyRepository;
    }
}
