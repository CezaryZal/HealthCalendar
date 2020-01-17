package com.CezaryZal.api.shortday;

import com.CezaryZal.api.shortday.entity.ShortDayDto;
import com.CezaryZal.api.shortday.manager.ShortDayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags = "ShortDay")
@RestController
@RequestMapping("/api/short-day")
public class ShortDayController {

    private final ShortDayService shortDayService;

    @Autowired
    public ShortDayController(ShortDayService shortDayService) {
        this.shortDayService = shortDayService;
    }

    @ApiOperation(value = "This will get a list `ShortDay` by date and user id")
    @GetMapping("/{date}/{userId}")
    public ResponseEntity<List<ShortDayDto>> getBodyByDateAndUserId (
            @PathVariable String date,
            @PathVariable Long userId){
        return new ResponseEntity<>(shortDayService.getShortDaysByDateAndUserId(date, userId), HttpStatus.OK);
    }

}
