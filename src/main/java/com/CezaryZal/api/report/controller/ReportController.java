package com.CezaryZal.api.report.controller;

import com.CezaryZal.api.report.manager.ReportService;
import com.CezaryZal.api.report.model.FormReport;
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
    public ResponseEntity<FormReport> getReportByDateAndUserId(
            @PathVariable String date,
            @PathVariable Long userId){
        Long now = System.currentTimeMillis();
        ResponseEntity<FormReport> tmp = new ResponseEntity<>(reportService.getFormReportByDateAndUserId(date, userId, false), HttpStatus.OK);
        Long time = System.currentTimeMillis() - now;
        System.out.println(time);
        return tmp;
    }

    @ApiOperation(value = "This will get a `LongReport` by date and user id")
    @GetMapping("/long/{date}/{userId}")
    public ResponseEntity<FormReport> getLongReportByDateAndUserId(
            @PathVariable String date,
            @PathVariable Long userId){
        return new ResponseEntity<>(reportService.getFormReportByDateAndUserId(date, userId, true), HttpStatus.OK);
    }

}
