package com.CezaryZal.day;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/day")
public class DayController {

    private DayService DService;

    @Autowired
    public DayController(DayService DService) {
        this.DService = DService;
    }

    @GetMapping("/id/{nrId}")
    public DayDB getDayDBById(@PathVariable int nrId){
        return DService.findById(nrId);
    }

    @GetMapping("/getDayByDateAndUserId/{date}/{userId}/{dayId}")
    public Day getDayByDateAndUserId(@PathVariable String date, @PathVariable int userId, @PathVariable int dayId){
        return DService.getDayByDateAndUserId(date, userId, dayId);
    }

    @GetMapping("/getDayDBbyDateAndUserId/{date}/{userId}")
    public DayDB getDayDBByDateAndUserId(@PathVariable String date, @PathVariable int userId){
        return DService.getDayDBByDateAndUserId(date, userId);
    }

    @GetMapping("/getAll")
    public List<DayDB> getAll(){
        return DService.getAll();
    }

    @PostMapping("/add")
    public boolean addDiet (@RequestBody DayDB dayDB){
        return DService.addDay(dayDB);
    }

    @PutMapping("/update")
    public boolean updateDay (@RequestBody DayDB dayDB){
        return DService.updateDay(dayDB);
    }

    @DeleteMapping("/delete/{id}")
    public String delete (@PathVariable int id){
        return DService.deleteDayById(id);
    }

}
