package com.CezaryZal.training;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/training")
public class TrainingController {

    private TrainingService TrainingS;

    public TrainingController(TrainingService TService) {
        this.TrainingS = TService;
    }

    @GetMapping("/id/{nrId}")
    public Training getMealById (@PathVariable int nrId){
        return TrainingS.getTrainingById(nrId);
    }

    @GetMapping("/getAllTrainingsDTOByDayId/{dayId}")
    public TrainingsDTO getTrainingsDTO(@PathVariable int dayId){
        return TrainingS.getTrainingsDTOByDayId(dayId);
    }

    @GetMapping("/getAll")
    public List<Training> getAllTrainings(){
        return TrainingS.getAllTrainings();
    }

    @PostMapping("/add")
    public boolean addDiet (@RequestBody Training training){
        return TrainingS.addTraining(training);
    }

    @PutMapping("/update")
    public boolean updateMeal (@RequestBody Training training){
        return TrainingS.updateTraining(training);
    }

    @DeleteMapping("/delete/{id}")
    public String delete (@PathVariable int id){
        return TrainingS.deleteTrainingById(id);
    }
}
