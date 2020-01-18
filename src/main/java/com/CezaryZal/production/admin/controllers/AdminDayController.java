package com.CezaryZal.production.admin.controllers;

import com.CezaryZal.api.day.entity.day.DayBasic;
import com.CezaryZal.api.day.entity.day.DayWithConnectedEntities;
import com.CezaryZal.api.day.manager.DayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags = "Admin day controller")
@RestController
@RequestMapping("/admin/api/day")
public class AdminDayController {

    private final DayService dayService;

    @Autowired
    public AdminDayController(DayService dayService) {
        this.dayService = dayService;
    }

    @ApiOperation(value = "This will get a basic information of `DayBasic` by id")
    @GetMapping("/basic/{id}")
    public ResponseEntity<DayBasic> getDayBasicById(@PathVariable Long id) {
        return new ResponseEntity<>(dayService.getDayBasicById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "This will get a `Day` with connected entities by id")
    @GetMapping("/with-entities/{id}")
    public ResponseEntity<DayWithConnectedEntities> getDayWithEntitiesById(@PathVariable Long id) {
        return new ResponseEntity<>(dayService.getDayWithEntitiesById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "This will get a basic information of `DayBasic` by date and user id")
    @GetMapping("/basic/{date}/{userId}")
    public ResponseEntity<DayBasic> getDayBasicByDateAndUserId(
            @PathVariable String date,
            @PathVariable Long userId) {
        return new ResponseEntity<>(dayService.getDayBasicByDateAndUserId(date, userId), HttpStatus.OK);
    }

    @ApiOperation(value = "This will get a `Day` with connected entities by date and user id")
    @GetMapping("/with-entities/{date}/{userId}")
    public ResponseEntity<DayWithConnectedEntities> getDayWithEntitiesByDateAndUserId(
            @PathVariable String date,
            @PathVariable Long userId) {
        return new ResponseEntity<>(dayService.getDayWithEntitiesByDateAndUserId(date, userId), HttpStatus.OK);
    }

    @ApiOperation(value = "This will get a list a basic information of `DayBasic`, all records")
    @GetMapping("/basic")
    public ResponseEntity<List<DayBasic>> getListDayBasic() {
        return new ResponseEntity<>(dayService.getDaysBasic(), HttpStatus.OK);
    }

    @ApiOperation(value = "This will get a list `Day` with connected entities, all records")
    @GetMapping("/with-entities")
    public ResponseEntity<List<DayWithConnectedEntities>> getListDayWithEntities() {
        return new ResponseEntity<>(dayService.getDaysWithEntities(), HttpStatus.OK);
    }

}
