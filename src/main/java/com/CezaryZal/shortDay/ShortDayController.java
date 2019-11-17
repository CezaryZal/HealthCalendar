package com.CezaryZal.shortDay;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shortDay")
public class ShortDayController {

    private ShortDayService shortDayS;

    public ShortDayController(ShortDayService shortDayS) {
        this.shortDayS = shortDayS;
    }

    @GetMapping("/id/{nrId}")
    public ShortDay getShortDayById (@PathVariable int nrId){
        return shortDayS.getShortDayById(nrId);
    }

    @GetMapping("/byDateAndUserId/{date}/{userId}")
    public List<ShortDay> getBodyByDateAndUserId (@PathVariable String date, @PathVariable int userId){
        return shortDayS.getShortDaysByDateAndUserId(date, userId);
    }

    @GetMapping("/getAll")
    public List<ShortDay> getAll(){
        return shortDayS.getAll();
    }

    @PostMapping("/add")
    public boolean addDiet (@RequestBody ShortDay shortDay){
        return shortDayS.addShortDay(shortDay);
    }

    @PutMapping("/update")
    public boolean updateShortDay (@RequestBody ShortDay shortDay){
        return shortDayS.updateShortDay(shortDay);
    }

    @DeleteMapping("/delete/{id}")
    public String delete (@PathVariable int id){
        return shortDayS.deleteShortDayById(id);
    }


}
