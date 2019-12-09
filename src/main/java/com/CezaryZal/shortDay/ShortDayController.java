package com.CezaryZal.shortDay;

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
    public boolean addDiet (@RequestBody ShortDay shortDay){
        return shortDayS.addShortDay(shortDay);
    }

    @PutMapping
    public boolean updateShortDay (@RequestBody ShortDay shortDay){
        return shortDayS.updateShortDay(shortDay);
    }

    @DeleteMapping("/{id}")
    public String delete (@PathVariable Long id){
        return shortDayS.deleteShortDayById(id);
    }


}
