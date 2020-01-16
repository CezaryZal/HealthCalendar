package com.CezaryZal.api.training;

import com.CezaryZal.api.training.entity.TrainingDto;
import com.CezaryZal.api.training.entity.TrainingsSummary;
import com.CezaryZal.api.training.manager.TrainingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags = "Training")
@RestController
@RequestMapping("/api/training")
public class TrainingController {

    private TrainingService trainingService;

    @Autowired
    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @ApiOperation(value = "This will get a `TrainingsSummary` by day id")
    @GetMapping("/dto/day-id/{dayId}")
    public ResponseEntity<TrainingsSummary> getTrainingsSummary(@PathVariable Long dayId){
        return new ResponseEntity<>(trainingService.getTrainingsSummaryByDayId(dayId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addDiet (@RequestBody TrainingDto trainingDto){
        return new ResponseEntity<>(trainingService.addTrainingByDto(trainingDto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<String> updateMeal (@RequestBody TrainingDto trainingDto){
        return new ResponseEntity<>(trainingService.updateTrainingByDto(trainingDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete (@PathVariable Long id){
        return new ResponseEntity<>(trainingService.deleteTraining(id), HttpStatus.NO_CONTENT);
    }
}
