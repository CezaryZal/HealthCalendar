package com.CezaryZal.production.admin.controllers;

import com.CezaryZal.api.day.model.DayDto;
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

    @ApiOperation(value = "This will get a `DayDto` by id")
    @GetMapping("/{id}")
    public ResponseEntity<DayDto> getDayWithEntitiesById(@PathVariable Long id) {
        return new ResponseEntity<>(dayService.getDayWithEntitiesById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "This will get a `DayDto` by date and user id")
    @GetMapping("/{date}/{userId}")
    public ResponseEntity<DayDto> getDayWithEntitiesByDateAndUserId(
            @PathVariable String date,
            @PathVariable Long userId) {
        return new ResponseEntity<>(dayService.getDayWithEntitiesByDateAndUserId(date, userId), HttpStatus.OK);
    }

    @ApiOperation(value = "This will get a list `DayDto`, all records")
    @GetMapping
    public ResponseEntity<List<DayDto>> getListDayWithEntities() {
        return new ResponseEntity<>(dayService.getDaysWithEntities(), HttpStatus.OK);
    }

}
