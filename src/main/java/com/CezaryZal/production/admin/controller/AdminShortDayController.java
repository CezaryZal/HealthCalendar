package com.CezaryZal.production.admin.controller;

import com.CezaryZal.api.shortday.entity.ShortDay;
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
@Api(tags = "Admin body controller")
@RestController
@RequestMapping("/admin/api/short-day")
public class AdminShortDayController {

    private final ShortDayService shortDayService;

    @Autowired
    public AdminShortDayController(ShortDayService shortDayService) {
        this.shortDayService = shortDayService;
    }

    @ApiOperation(value = "This will get a `ShortDay` by id")
    @GetMapping("/{id}")
    public ResponseEntity<ShortDayDto> getShortDayById (@PathVariable Long id){
        return new ResponseEntity<>(shortDayService.getShortDayDtoById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "This will get a list `ShortDay`, all records")
    @GetMapping
    public ResponseEntity<List<ShortDayDto>> getListShortDay(){
        return new ResponseEntity<>(shortDayService.getShorts(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addShortDay (@RequestBody ShortDay shortDay){
        return new ResponseEntity<>(shortDayService.addShort(shortDay), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<String> updateShortDay (@RequestBody ShortDay shortDay){
        return new ResponseEntity<>(shortDayService.updateShort(shortDay), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteShortDayById (@PathVariable Long id){
        return new ResponseEntity<>(shortDayService.deleteShortById(id), HttpStatus.NO_CONTENT);
    }
}
