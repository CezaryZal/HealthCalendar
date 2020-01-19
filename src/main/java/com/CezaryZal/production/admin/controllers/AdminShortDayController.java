package com.CezaryZal.production.admin.controllers;

import com.CezaryZal.api.shortday.entity.ShortDayDto;
import com.CezaryZal.api.shortday.manager.ShortDayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags = "Admin body controller")
@RestController
@RequestMapping("/admin/api/short-day")
public class AdminShortDayController {

    private final ShortDayService shortDayService;

    @Autowired
    public AdminShortDayController(ShortDayService shortDayService) {
        this.shortDayService = shortDayService;
    }

    @ApiOperation(value = "This will get a `ShortDay` by id")
    @GetMapping("/{id}")
    public ResponseEntity<ShortDayDto> getShortDayById (@PathVariable Long id){
        return new ResponseEntity<>(shortDayService.getShortDayDtoById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "This will get a `ShortDay` by date and user id")
    @GetMapping("/{localDate}/{userId}")
    public ResponseEntity<ShortDayDto> getShortDayById (@PathVariable LocalDate localDate, @PathVariable Long userId){
        return new ResponseEntity<>(shortDayService.getShortDayDtoByDateAndUserId(localDate, userId), HttpStatus.OK);
    }

    @ApiOperation(value = "This will get a list `ShortDay`, all records")
    @GetMapping
    public ResponseEntity<List<ShortDayDto>> getListShortDay(){
        return new ResponseEntity<>(shortDayService.getShorts(), HttpStatus.OK);
    }
}
