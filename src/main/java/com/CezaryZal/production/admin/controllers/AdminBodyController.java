package com.CezaryZal.production.admin.controllers;

import com.CezaryZal.api.body.manager.BodySizeService;
import com.CezaryZal.api.body.model.FormBodySize;
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

    @ApiOperation(value = "This will get a `BodySize` by id", notes = "In this method you will receive a body measurement by id")
    @GetMapping("/{id}")
    public ResponseEntity<FormBodySize> getBodySizeDtoById(@PathVariable Long id) {
        return new ResponseEntity<>(bodySizeService.getBodySizeDtoById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "This will get a list `BodySizeDto`, all records")
    @GetMapping
    public ResponseEntity<List<FormBodySize>> getListBodySizeDto() {
        return new ResponseEntity<>(bodySizeService.getListBodySizeDto(), HttpStatus.OK);
    }

}
