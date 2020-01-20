package com.CezaryZal.api.shortReport;

import com.CezaryZal.api.shortReport.entity.ShortReportDto;
import com.CezaryZal.api.shortReport.manager.ShortReportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags = "ShortReport")
@RestController
@RequestMapping("/api/short-report")
public class ShortReportController {

    private final ShortReportService shortReportService;

    @Autowired
    public ShortReportController(ShortReportService shortReportService) {
        this.shortReportService = shortReportService;
    }

    @ApiOperation(value = "This will get a list `ShortReport` by date and user id")
    @GetMapping("/{date}/{userId}")
    public ResponseEntity<List<ShortReportDto>> getShortReportByDateAndUserId (
            @PathVariable String date,
            @PathVariable Long userId){
        return new ResponseEntity<>(shortReportService.getShortReportsByInputDateAndUserId(date, userId), HttpStatus.OK);
    }

}
