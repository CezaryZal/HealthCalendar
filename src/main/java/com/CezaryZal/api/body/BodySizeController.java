package com.CezaryZal.api.body;

import com.CezaryZal.api.body.model.BodySizeDto;
import com.CezaryZal.api.body.manager.BodySizeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags = "Body Size")
@RestController
@RequestMapping("/api/body")
public class BodySizeController {

    private final BodySizeService bodySizeService;

    @Autowired
    public BodySizeController(BodySizeService bodySizeService) {
        this.bodySizeService = bodySizeService;
    }

    @ApiOperation(value = "This will get a last date measure by user id")
    @GetMapping("/date/user-id/{userId}")
    public ResponseEntity<LocalDate> getDateLastMeasureByUserId(@PathVariable Long userId) {
        return new ResponseEntity<>(bodySizeService.getDateLastMeasureByUserIdForBSController(userId), HttpStatus.OK);
    }

    @ApiOperation(value = "This will be get a list dates by user id")
    @GetMapping("/dates/user-id/{userId}")
    public ResponseEntity<List<LocalDate>> getListDatesByUserId(@PathVariable Long userId) {
        return new ResponseEntity<>(bodySizeService.getListDatesByUserId(userId), HttpStatus.OK);
    }

    @ApiOperation(value = "This will be get a `BodySize` by date and user id")
    @GetMapping("/{date}/{userId}")
    public ResponseEntity<BodySizeDto> getBodyByDateAndUserId(
            @PathVariable String date,
            @PathVariable Long userId) {
        return new ResponseEntity<>(bodySizeService.getBodyDtoByDateAndUserId(date, userId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addBody(@RequestBody BodySizeDto bodySize) {
        return new ResponseEntity<>(bodySizeService.addBodySizeByDto(bodySize), HttpStatus.CREATED);
    }

    //TO DO - zmiana tylko w dniu zapisu
    @ApiOperation(value = "This endpoint input `BodySize` object update ")
    @PutMapping("/{id}")
    public ResponseEntity<String> updateBodySizeByDao(@RequestBody BodySizeDto bodySizeDto, @PathVariable Long id) {
        return new ResponseEntity<>(bodySizeService.updateBodySizeByDto(bodySizeDto, id), HttpStatus.OK);
    }

    //TO DO - usunięcie tylko w dniu zapisu
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBodyById(@PathVariable Long id) {
        return new ResponseEntity<>(bodySizeService.deleteBodySizeById(id), HttpStatus.NO_CONTENT);
    }
}
