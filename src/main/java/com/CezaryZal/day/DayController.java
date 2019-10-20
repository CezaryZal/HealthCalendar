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
    public DayDB getDayDBById(@PathVariable int nrId){
        return dayS.findById(nrId);
    }

    @GetMapping("/getDayByDateAndUserId/{date}/{userId}")
    public Day getDayByDateAndUserId(@PathVariable String date, @PathVariable int userId){
        return dayS.getDayByDateAndUserId(date, userId);
    }

    @GetMapping("/getDayId/{date}/{userId}")
    public int getIntDayIdByDateAndUserId(@PathVariable String date, @PathVariable int userId){
        return dayS.getDayIdByDateAndUserId(date, userId);
    }

    @GetMapping("/getDayDBbyDateAndUserId/{date}/{userId}")
    public DayDB getDayDBByDateAndUserId(@PathVariable String date, @PathVariable int userId){
        return dayS.getDayDBByDateAndUserId(date, userId);
    }

    @GetMapping("/getAll")
    public List<DayDB> getAll(){
        return dayS.getAll();
    }

    @PostMapping("/add")
    public boolean addDiet (@RequestBody DayDB dayDB){
        return dayS.addDay(dayDB);
    }

    @PutMapping("/update")
    public boolean updateDay (@RequestBody DayDB dayDB){
        return dayS.updateDay(dayDB);
    }

    @DeleteMapping("/delete/{id}")
    public String delete (@PathVariable int id){
        return dayS.deleteDayById(id);
    }

}
