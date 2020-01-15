package com.CezaryZal.production;

import com.CezaryZal.api.body.entity.BodySizeDto;
import com.CezaryZal.api.body.manager.BodySizeService;
import com.CezaryZal.api.limits.entity.DailyLimits;
import com.CezaryZal.api.limits.entity.DailyLimitsDto;
import com.CezaryZal.api.limits.manager.DailyLimitsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags = "Admin controller")
@RestController
@RequestMapping("/admin/api")
public class AdminController {

    private BodySizeService bodySizeService;
    private DailyLimitsService dailyLimitsService;

    @Autowired
    public AdminController(BodySizeService bodySizeService, DailyLimitsService dailyLimitsService) {
        this.bodySizeService = bodySizeService;
        this.dailyLimitsService = dailyLimitsService;
    }

    @ApiOperation(value = "This will get a list `BodySize`, all records")
    @GetMapping("/body/list")
    public List<BodySizeDto> getListBodySizeDto() {
        return bodySizeService.getListBodySizeDto();
    }

    @ApiOperation(value = "This endpoint input `BodySize` object update ")
    @PutMapping("/body/update")
    public ResponseEntity<String> updateBodySizeByDao(@RequestBody BodySizeDto bodySizeDto) {
        String answer = bodySizeService.updateBodySizeByDao(bodySizeDto);
        return new ResponseEntity<>(answer, HttpStatus.OK);
    }

    @ApiOperation(value = "This will get a list `DailyLimits`, all records")
    @GetMapping("/limits/list")
    public ResponseEntity<List<DailyLimitsDto>> getListLimitsDto(){
        return new ResponseEntity<>(dailyLimitsService.getListLimitsDto(), HttpStatus.OK);
    }

    @ApiOperation(value = "This endpoint addition `DailyLimits`")
    @PostMapping
    public ResponseEntity<String> addLimits (@RequestBody DailyLimits dailyLimits){
        return new ResponseEntity<>(dailyLimitsService.addDailyLimits(dailyLimits), HttpStatus.OK);
    }

    @ApiOperation(value = "This endpoint remove `DailyLimits` by id")
    @DeleteMapping("/limits/delete/{id}")
    public ResponseEntity<String> deleteLimitsById (@PathVariable Long id){
        return new ResponseEntity<>(dailyLimitsService.deleteDailyLimitsById(id), HttpStatus.NO_CONTENT);
    }

}
