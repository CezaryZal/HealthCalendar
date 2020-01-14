package com.CezaryZal.api.body;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags = "Body Size")
@RestController
@RequestMapping("/api/body")
public class BodySizeController {

    private BodySizeService bodySizeS;

    public BodySizeController(BodySizeService bodySizeS) {
        this.bodySizeS = bodySizeS;
    }

    @ApiOperation(value = "This will get a `BodySize by id", notes = "In this method you will receive a body measurement by id")
    @GetMapping("/{id}")
    public BodySize getBodyById (@PathVariable Long id){
        return bodySizeS.getBodyById(id);
    }

    @ApiOperation(value = "This will get a last date measure by user id")
    @GetMapping("/date/user-id/{userId}")
    public LocalDate getDateLastMeasureByUserId(@PathVariable Long userId){
        return bodySizeS.getDateLastMeasureByUserId(userId);
    }

    @ApiOperation(value = "This will be get a list dates by user id")
    @GetMapping("/dates/user-id/{userId}")
    public List<LocalDate> getListDatesByUserId (@PathVariable Long userId){
        return bodySizeS.getListDatesByUserId(userId);
    }

    @ApiOperation(value = "This will be get a `BodySize` by date and user id")
    @GetMapping("/{date}/{userId}")
    public BodySize getBodyByDateAndUserId (@PathVariable String date, @PathVariable Long userId){
        return bodySizeS.getBodyByDateAndUserId(date, userId);
    }

    @ApiOperation(value = "This will get a list `BodySize`, all records")
    @GetMapping
    public List<BodySize> getAll(){
        return bodySizeS.getAll();
    }

    @PostMapping
    public void addBody (@RequestBody BodySize bodySize){
        bodySizeS.addBody(bodySize);
    }

    @DeleteMapping("/{id}")
    public void deleteBodyById (@PathVariable Long id) {
        bodySizeS.deleteBodyById(id);
    }


}
