//package com.CezaryZal.bodySize;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/body")
//public class BodySizeController {
//
//    private BodySizeService BSService;
//
//    @Autowired
//    public BodySizeController(BodySizeService BSService) {
//        this.BSService = BSService;
//    }
//
//
//    @GetMapping("/id/{nrId}")
//    public BodySize getBodySize (@PathVariable int nrId){
//        BodySize bodySize = BSService.findById(nrId);
//
//        return bodySize;
//    }
//
////    @GetMapping("/dateAndUser/{userId}/{date}")
////    public BodySize getBodySizeByDateAndUserId (@PathVariable int userId, @PathVariable String date){
////        BodySize bodySize = bodyService.getBodySizeByDateAndUserId(userId, date);
////
////        return bodySize;
////    }
//}
