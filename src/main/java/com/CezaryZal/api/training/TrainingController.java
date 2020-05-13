package com.CezaryZal.api.training;

import com.CezaryZal.api.ApiEntityController;
import com.CezaryZal.api.training.model.TrainingDto;
import com.CezaryZal.api.training.model.TrainingsSummary;
import com.CezaryZal.api.training.manager.TrainingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags = "Training")
@RestController
@RequestMapping("/api/training")
public class TrainingController implements ApiEntityController {

    private final TrainingService trainingService;

    @Autowired
    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @ApiOperation(value = "This will get a `TrainingsSummary` by day id and user id")
    @GetMapping("/trainings-summary/day-id/{dayId}/{userId}")
    public ResponseEntity<TrainingsSummary> getTrainingsSummary(@PathVariable Long dayId, @PathVariable Long userId){
        return new ResponseEntity<>(trainingService.getTrainingsSummaryByDayId(dayId, userId), HttpStatus.OK);
    }

    @ApiOperation(value = "This will get a `TrainingsSummary` by day date and userId")
    @GetMapping("/trainings-summary/date/{inputDate}/{userId}")
    public ResponseEntity<TrainingsSummary> getTrainingsSummaryByDateAndUserId(
            @PathVariable String inputDate, @PathVariable Long userId){
        return new ResponseEntity<>(trainingService.getTrainingSummaryByDateAndUserId(inputDate, userId), HttpStatus.OK);
    }

    @PostMapping("current/{userId}")
    public ResponseEntity<String> add (@RequestBody TrainingDto trainingDto, @PathVariable Long userId){
        return new ResponseEntity<>(trainingService.addModelByDtoAndUserId(trainingDto, userId), HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<String> update (@RequestBody TrainingDto trainingDto, @PathVariable Long userId){
        return new ResponseEntity<>(trainingService.updateModelByDtoAndUserId(trainingDto, userId), HttpStatus.OK);
    }

    @DeleteMapping("/{mealId}/{userId}")
    public ResponseEntity<String> delete (@PathVariable Long mealId, @PathVariable Long userId){
        return new ResponseEntity<>(trainingService.deleteByModelIdAndUserId(mealId, userId), HttpStatus.NO_CONTENT);
    }
}
