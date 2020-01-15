package com.CezaryZal.production;

import com.CezaryZal.api.body.entity.BodySizeDto;
import com.CezaryZal.api.body.manager.BodySizeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

    public AdminController(BodySizeService bodySizeService) {
        this.bodySizeService = bodySizeService;
    }

    @ApiOperation(value = "This will get a list `BodySize`, all records")
    @GetMapping("/body/list")
    public List<BodySizeDto> getListBodySizeDto() {
        return bodySizeService.getListBodySizeDto();
    }

    @PutMapping("/body/update")
    public ResponseEntity<String> updateBodySizeByDao(@RequestBody BodySizeDto bodySizeDto) {
        String answer = bodySizeService.updateBodySizeByDao(bodySizeDto);
        return new ResponseEntity<>(answer, HttpStatus.OK);
    }

}
