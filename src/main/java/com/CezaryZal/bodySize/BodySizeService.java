//package com.CezaryZal.bodySize;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//
//
//@Transactional
//@Service
//public class BodySizeService {
//
//    private BodySizeRepository BSRepository;
//
//    @Autowired
//    public BodySizeService(BodySizeRepository BSRepository) {
//        this.BSRepository = BSRepository;
//    }
//
//    public BodySize findById (int id){
//        BodySize bodySize = BSRepository.findById(id);
//
//        return bodySize;
//    }
//}
