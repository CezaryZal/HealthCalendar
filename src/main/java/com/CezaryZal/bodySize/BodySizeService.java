package com.CezaryZal.bodySize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BodySizeService {

    @Autowired
    private BodySizeRepository bodyRepository;
}
