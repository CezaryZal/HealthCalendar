package com.CezaryZal.production.admin.controllers;

import com.CezaryZal.api.limits.model.DailyLimitsDto;
import com.CezaryZal.api.limits.manager.DailyLimitsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags = "Admin limits controller")
@RestController
@RequestMapping("/admin/api/limits")
public class AdminLimitsController {

    private final DailyLimitsService dailyLimitsService;

    @Autowired
    public AdminLimitsController(DailyLimitsService dailyLimitsService) {
        this.dailyLimitsService = dailyLimitsService;
    }

    @ApiOperation(value = "This will get a list `DailyLimits`, all records")
    @GetMapping
    public ResponseEntity<List<DailyLimitsDto>> getListLimitsDto(){
        return new ResponseEntity<>(dailyLimitsService.getListLimitsDto(), HttpStatus.OK);
    }
}
