package com.CezaryZal.production.admin.controllers;

import com.CezaryZal.api.report.shortened.manager.ShortReportService;
import com.CezaryZal.api.report.shortened.model.ShortReportDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags = "Admin body controller")
@RestController
@RequestMapping("/admin/api/short-report")
public class AdminShortReportController {

    private final ShortReportService shortReportService;

    @Autowired
    public AdminShortReportController(ShortReportService shortReportService) {
        this.shortReportService = shortReportService;
    }

    @ApiOperation(value = "This will get a `ShortReport` by id")
    @GetMapping("/{id}")
    public ResponseEntity<ShortReportDto> getShortReportById(@PathVariable Long id){
        return new ResponseEntity<>(shortReportService.getShortReportDtoById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "This will get a `ShortReport` by date and user id")
    @GetMapping("/{inputDate}/{userId}")
    public ResponseEntity<ShortReportDto> getShortReportById(@PathVariable String inputDate, @PathVariable Long userId){
        return new ResponseEntity<>(shortReportService.getShortReportDtoByDateAndUserId(inputDate, userId), HttpStatus.OK);
    }

    @ApiOperation(value = "This will get a list `ShortReport`, all records")
    @GetMapping
    public ResponseEntity<List<ShortReportDto>> getListShortReport(){
        return new ResponseEntity<>(shortReportService.getShorts(), HttpStatus.OK);
    }
}
