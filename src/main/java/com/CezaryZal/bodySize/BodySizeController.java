package com.CezaryZal.bodySize;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags = "Body Size")
@RestController
@RequestMapping("/body")
public class BodySizeController {

    private BodySizeService bodySizeS;

    public BodySizeController(BodySizeService bodySizeS) {
        this.bodySizeS = bodySizeS;
    }

    @ApiOperation(value = "This will get a Body by id", notes = "In this method you will receive a body measurement by id")
    @GetMapping("/id/{id}")
    public BodySize getBodyById (@PathVariable Long id){
        return bodySizeS.getBodyById(id);
    }

    @GetMapping("/byLastDate/{userId}")
    public LocalDate getDateLastMeasureByUserId(@PathVariable Long userId){
        return bodySizeS.getDateLastMeasureByUserId(userId);
    }

    @GetMapping("/byUserIdAllDate/{userId}")
    public List<LocalDate> getListDatesByUserIdAllDate (@PathVariable Long userId){
        return bodySizeS.getListDatesByUserIdAllDate(userId);
    }

    @GetMapping("/byDateAndUserId/{date}/{userId}")
    public BodySize getBodyByDateAndUserId (@PathVariable String date, @PathVariable Long userId){
        return bodySizeS.getBodyByDateAndUserId(date, userId);
    }

    @GetMapping("/getAll")
    public List<BodySize> getAll(){
        return bodySizeS.getAll();
    }

    @PostMapping("/add")
    public boolean addBody (@RequestBody BodySize bodySize){
        return bodySizeS.addBody(bodySize);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBodyById (@PathVariable Long id) {
        return bodySizeS.deleteBodyById(id);
    }


}
