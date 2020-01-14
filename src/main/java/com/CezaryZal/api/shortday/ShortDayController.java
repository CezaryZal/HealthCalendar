package com.CezaryZal.api.shortday;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags = "ShortDay")
@RestController
@RequestMapping("/api/shortDay")
public class ShortDayController {

    private ShortDayService shortDayS;

    public ShortDayController(ShortDayService shortDayS) {
        this.shortDayS = shortDayS;
    }

    @ApiOperation(value = "This will get a `ShortDay` by id")
    @GetMapping("/{id}")
    public ShortDay getShortDayById (@PathVariable Long id){
        return shortDayS.getShortDayById(id);
    }

    @ApiOperation(value = "This will get a list `ShortDay` by date and user id")
    @GetMapping("/{date}/{userId}")
    public List<ShortDay> getBodyByDateAndUserId (@PathVariable String date, @PathVariable Long userId){
        return shortDayS.getShortDaysByDateAndUserId(date, userId);
    }

    @ApiOperation(value = "This will get a list `ShortDay`, all records")
    @GetMapping
    public List<ShortDay> getAll(){
        return shortDayS.getAll();
    }

    @PostMapping
    public void addDiet (@RequestBody ShortDay shortDay){
        shortDayS.addShortDay(shortDay);
    }

    @PutMapping
    public void updateShortDay (@RequestBody ShortDay shortDay){
        shortDayS.updateShortDay(shortDay);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable Long id){
        shortDayS.deleteShortDayById(id);
    }


}
