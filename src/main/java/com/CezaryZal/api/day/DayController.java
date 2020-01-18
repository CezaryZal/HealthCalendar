package com.CezaryZal.api.day;

import com.CezaryZal.api.day.entity.api.DayApi;
import com.CezaryZal.api.day.entity.day.Day;
import com.CezaryZal.api.day.entity.api.DayApiWithConnectedEntities;
import com.CezaryZal.api.day.entity.day.DayBasic;
import com.CezaryZal.api.day.manager.DayApiService;
import com.CezaryZal.api.day.manager.DayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;

@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags = "Day")
@RestController
@RequestMapping("/api/day")
public class DayController {

    private final DayService dayService;
    private final DayApiService dayApiService;

    @Autowired
    public DayController(DayService dayService, DayApiService dayApiService) {
        this.dayService = dayService;
        this.dayApiService = dayApiService;
    }

    @ApiOperation(value = "This will get a day id by date and user id")
    @GetMapping("/day-id/{date}/{userId}")
    public ResponseEntity<Long> getDayIdByDateAndUserId(
            @PathVariable String date,
            @PathVariable Long userId) {
        return new ResponseEntity<>(dayService.getDayIdByDateAndUserId(date, userId), HttpStatus.OK);
    }

    @ApiOperation(value = "This will get a basic information of `DayApi` by date and user id")
    @GetMapping("/api/basic/{date}/{userId}")
    public ResponseEntity<DayApi> getDayApiByDateAndUserId(
            @PathVariable String date,
            @PathVariable Long userId){
        long currentTime = System.currentTimeMillis();
        ResponseEntity<DayApi> dayApiResponseEntity = new ResponseEntity<>(dayApiService.getDayApiByDateAndUserId(date, userId), HttpStatus.OK);
        Long processTime = System.currentTimeMillis() - currentTime;
        System.out.println(processTime);
        return dayApiResponseEntity;
    }

    @ApiOperation(value = "This will get a `DayApi` with connected entities by date and user id")
    @GetMapping("/api/with-entities/{date}/{userId}")
    public ResponseEntity<DayApiWithConnectedEntities> getDayApiWithEntitiesByDateAndUserId(
            @PathVariable String date,
            @PathVariable Long userId){
        long currentTime = System.currentTimeMillis();
        ResponseEntity<DayApiWithConnectedEntities> dayApiWithConnectedEntitiesResponseEntity =
                new ResponseEntity<>(dayApiService.getDayApiWithEntitiesByDateAndUserId(date, userId), HttpStatus.OK);
        Long processTime = System.currentTimeMillis() - currentTime;
        System.out.println(processTime);
        return dayApiWithConnectedEntitiesResponseEntity;
    }

    @PostMapping
    public ResponseEntity<String> addDay(@RequestBody DayBasic day) {
        return new ResponseEntity<>(dayService.addNewDay(day), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<String> updateDay(@RequestBody Day day) {
        return new ResponseEntity<>(dayService.update(day), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDayById(@PathVariable Long id) {
        return new ResponseEntity<>(dayService.deleteDay(id), HttpStatus.NO_CONTENT);
    }

}
