package com.CezaryZal.production.admin.controllers;

import com.CezaryZal.api.body.manager.BodySizeService;
import com.CezaryZal.api.body.model.BodySizeDto;
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
@RequestMapping("/admin/api/body")
public class AdminBodyController {

    private final BodySizeService bodySizeService;

    @Autowired
    public AdminBodyController(BodySizeService bodySizeService) {
        this.bodySizeService = bodySizeService;
    }

    @ApiOperation(value = "This will get a `BodySizeDto` by id", notes = "In this method you will receive a body measurement by id")
    @GetMapping("/{id}")
    public ResponseEntity<BodySizeDto> getBodySizeDtoById(@PathVariable Long id) {
        return new ResponseEntity<>(bodySizeService.getBodySizeDtoById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "This will get a `BodySizeDto` by user id")
    @GetMapping("/userId/{id}")
    public ResponseEntity<List<BodySizeDto>> getListBodySizeDtoByUserId(@PathVariable Long userId) {
        return new ResponseEntity<>(bodySizeService.getListBodySizeDtoByUserId(userId), HttpStatus.OK);
    }

    @ApiOperation(value = "This will get a list `BodySizeDto`, all records")
    @GetMapping
    public ResponseEntity<List<BodySizeDto>> getListBodySizeDto() {
        return new ResponseEntity<>(bodySizeService.getListBodySizeDto(), HttpStatus.OK);
    }

}
