package com.CezaryZal.day;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/day")
public class DayController {

    private DayService dayS;

    @Autowired
    public DayController(DayService DService) {
        this.dayS = DService;
    }

    @GetMapping("/id/{nrId}")
    public Day getDayById(@PathVariable int nrId){
        return dayS.getDayById(nrId);
    }

    @GetMapping("/getDayDTOByDateAndUserId/{date}/{userId}")
    public DayDTO getDayDTOByDateAndUserId(@PathVariable String date, @PathVariable int userId){
        return dayS.getDayDTOByDateAndUserId(date, userId);
    }

    @GetMapping("/getDayId/{date}/{userId}")
    public int getIntDayIdByDateAndUserId(@PathVariable String date, @PathVariable int userId){
        return dayS.getDayIdByDateAndUserId(date, userId);
    }

    @GetMapping("/getDayDBbyDateAndUserId/{date}/{userId}")
    public Day getDayDBByDateAndUserId(@PathVariable String date, @PathVariable int userId){
        return dayS.getDayDBByDateAndUserId(date, userId);
    }

    @GetMapping("/getAll")
    public List<Day> getAll(){
        return dayS.getAll();
    }

    @PostMapping("/add")
    public boolean addDiet (@RequestBody Day day){
        return dayS.addDay(day);
    }

    @PutMapping("/update")
    public boolean updateDay (@RequestBody Day day){
        return dayS.updateDay(day);
    }

    @DeleteMapping("/delete/{id}")
    public String delete (@PathVariable int id){
        return dayS.deleteDayById(id);
    }

}
