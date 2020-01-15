package com.CezaryZal.api.day;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags = "Day")
@RestController
@RequestMapping("/api/day")
public class DayController {

    private DayService dayS;

    public DayController(DayService DService) {
        this.dayS = DService;
    }

    @ApiOperation(value = "This will get a `Day` by id")
    @GetMapping("/{id}")
    public Day getDayById(@PathVariable Long id){
        return dayS.getDayById(id);
    }

    @ApiOperation(value = "This will get a `DayDTO` by date and user id")
    @GetMapping("/dto/{date}/{userId}")
    public DayDTO getDayDTOByDateAndUserId(@PathVariable String date, @PathVariable Long userId) throws AccountNotFoundException {
        return dayS.getDayDTOByDateAndUserId(date, userId);
    }

    @ApiOperation(value = "This will get a day id by date and user id")
    @GetMapping("/day-id/{date}/{userId}")
    public Long getDayIdByDateAndUserId(@PathVariable String date, @PathVariable Long userId){
        return dayS.getDayIdByDateAndUserId(date, userId);
    }

    @ApiOperation(value = "This will get a `Day` by date and user id")
    @GetMapping("/{date}/{userId}")
    public Day getDayByDateAndUserId(@PathVariable String date, @PathVariable Long userId){
        return dayS.getDayByDateAndUserId(date, userId);
    }

    @ApiOperation(value = "This will get a list `Day`, all records")
    @GetMapping
    public List<Day> getAll(){
        return dayS.getAll();
    }

    @PostMapping
    public String addDiet (@RequestBody Day day) throws AccountNotFoundException {
        return dayS.addDay(day);
    }

    @PutMapping
    public String updateDay (@RequestBody Day day) throws AccountNotFoundException {
        return dayS.updateDay(day);
    }

    @DeleteMapping("/{id}")
    public String delete (@PathVariable Long id){
        return dayS.deleteDayById(id);
    }

}
