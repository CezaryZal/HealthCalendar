package com.CezaryZal.training;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags = "Training")
@RestController
@RequestMapping("/training")
public class TrainingController {

    private TrainingService TrainingS;

    public TrainingController(TrainingService TService) {
        this.TrainingS = TService;
    }

    @ApiOperation(value = "This will get a `Training` by id")
    @GetMapping("/{id}")
    public Training getMealById (@PathVariable Long id){
        return TrainingS.getTrainingById(id);
    }

    @ApiOperation(value = "This will get a `TrainingDTO` by day id")
    @GetMapping("/dto/day-id/{dayId}")
    public TrainingsDTO getTrainingsDTO(@PathVariable Long dayId){
        return TrainingS.getTrainingsDTOByDayId(dayId);
    }

    @ApiOperation(value = "This will get a list `Training`, all records")
    @GetMapping
    public List<Training> getAllTrainings(){
        return TrainingS.getAllTrainings();
    }

    @PostMapping
    public boolean addDiet (@RequestBody Training training){
        return TrainingS.addTraining(training);
    }

    @PutMapping
    public boolean updateMeal (@RequestBody Training training){
        return TrainingS.updateTraining(training);
    }

    @DeleteMapping("/{id}")
    public String delete (@PathVariable Long id){
        return TrainingS.deleteTrainingById(id);
    }
}
