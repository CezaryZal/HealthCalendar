package com.CezaryZal.api.day;

import com.CezaryZal.api.day.manager.repo.DayRepoService;
import com.CezaryZal.api.day.model.ObjectToSaveDay;
import com.CezaryZal.api.report.manager.ReportService;
import com.CezaryZal.api.day.manager.DayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags = "Day")
@RestController
@RequestMapping("/api/day")
public class DayController {

    private final DayService dayService;
    private final DayRepoService dayRepoService;

    @Autowired
    public DayController(DayService dayService, DayRepoService dayRepoService) {
        this.dayService = dayService;
        this.dayRepoService = dayRepoService;
    }

    @ApiOperation(value = "This will get a day id by date and user id")
    @GetMapping("/day-id/{date}/{userId}")
    public ResponseEntity<Long> getDayIdByDateAndUserId(
            @PathVariable String date,
            @PathVariable Long userId) {
        return new ResponseEntity<>(dayRepoService.getDayIdByDateAndUserId(date, userId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addDay(@RequestBody ObjectToSaveDay day) {
        return new ResponseEntity<>(dayService.addNewDay(day), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<String> updateDay(@RequestBody ObjectToSaveDay day) {
        return new ResponseEntity<>(dayService.update(day), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDayById(@PathVariable Long id) {
        return new ResponseEntity<>(dayService.deleteDay(id), HttpStatus.NO_CONTENT);
    }

}
