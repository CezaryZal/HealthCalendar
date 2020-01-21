package com.CezaryZal.api.report.controller;

import com.CezaryZal.api.report.manager.ReportService;
import com.CezaryZal.api.report.model.Report;
import com.CezaryZal.api.report.model.LongReport;
import com.CezaryZal.api.day.manager.DayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags = "Report of day")
@RestController
@RequestMapping("/api/report")
public class ReportController {

    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @ApiOperation(value = "This will get a `Report` by date and user id")
    @GetMapping("/{date}/{userId}")
    public ResponseEntity<Report> getDayApiByDateAndUserId(
            @PathVariable String date,
            @PathVariable Long userId){
        return new ResponseEntity<>(reportService.getDayApiByDateAndUserId(date, userId), HttpStatus.OK);
    }

    @ApiOperation(value = "This will get a `LongReport` by date and user id")
    @GetMapping("/long/{date}/{userId}")
    public ResponseEntity<LongReport> getDayApiWithEntitiesByDateAndUserId(
            @PathVariable String date,
            @PathVariable Long userId){
        return new ResponseEntity<>(reportService.getDayApiWithEntitiesByDateAndUserId(date, userId), HttpStatus.OK);
    }

}
