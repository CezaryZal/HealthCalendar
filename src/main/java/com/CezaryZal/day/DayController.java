package com.CezaryZal.day;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/day")
public class DayController {

    private DayService dayService;

    @Autowired
    public DayController(DayService dayService) {
        this.dayService = dayService;
    }

    @GetMapping("/listDays")
    public List<Day> getDays(){
        return dayService.getDays();
    }

    @GetMapping("/id/{dayId}")
    public Day getDay (@PathVariable int dayId){
        Day day = dayService.getDay(dayId);

        return day;
    }
}
