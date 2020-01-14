package com.CezaryZal.api.body;

import com.CezaryZal.api.body.entity.BodySizeDao;
import com.CezaryZal.api.body.entity.BodySizeDto;
import com.CezaryZal.api.body.manager.BodySizeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags = "Body Size")
@RestController
@RequestMapping("/api/body")
public class BodySizeController {

    private BodySizeService bodySizeService;

    @Autowired
    public BodySizeController(BodySizeService bodySizeService) {
        this.bodySizeService = bodySizeService;
    }

    @ApiOperation(value = "This will get a `BodySize` by id", notes = "In this method you will receive a body measurement by id")
    @GetMapping("/{id}")
    public BodySizeDto getBodySizeDtoById(@PathVariable Long id) {
        return bodySizeService.getBodySizeDtoById(id);
    }

    @ApiOperation(value = "This will get a last date measure by user id")
    @GetMapping("/date/user-id/{userId}")
    public LocalDate getDateLastMeasureByUserId(@PathVariable Long userId) {
        return bodySizeService.getDateLastMeasureByUserId(userId);
    }

    @ApiOperation(value = "This will be get a list dates by user id")
    @GetMapping("/dates/user-id/{userId}")
    public List<LocalDate> getListDatesByUserId(@PathVariable Long userId) {
        return bodySizeService.getListDatesByUserId(userId);
    }

    @ApiOperation(value = "This will be get a `BodySize` by date and user id")
    @GetMapping("/{date}/{userId}")
    public BodySizeDto getBodyByDateAndUserId(@PathVariable String date, @PathVariable Long userId) {
        return bodySizeService.getBodyDtoByDateAndUserId(date, userId);
    }

    @PostMapping
    public String addBody(@RequestBody BodySizeDao bodySize) {
        return bodySizeService.addBodySizeByDao(bodySize);
    }

    //TO DO - usunięcie tylko w dniu zapisu
    @DeleteMapping("/{id}")
    public String deleteBodyById(@PathVariable Long id) {
        return bodySizeService.deleteBodySizeById(id);
    }


}
