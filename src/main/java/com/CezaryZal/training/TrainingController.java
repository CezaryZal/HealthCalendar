package com.CezaryZal.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/training")
public class TrainingController {

    private TrainingService TrainingS;

    @Autowired
    public TrainingController(TrainingService TService) {
        this.TrainingS = TService;
    }

    @GetMapping("/id/{nrId}")
    public TrainingDB getMealById (@PathVariable int nrId){
        return TrainingS.findById(nrId);
    }

    @GetMapping("/getTrainingsByDayId/{dayId}")
    public AllTrainingsByDay getTrainings(@PathVariable int dayId){
        return TrainingS.getTrainingsByDay(dayId);
    }

    @GetMapping("/getAll")
    public List<TrainingDB> getAll(){
        return TrainingS.getAll();
    }

    @PostMapping("/add")
    public boolean addDiet (@RequestBody TrainingDB trainingDB){
        return TrainingS.addTraining(trainingDB);
    }

    @PutMapping("/update")
    public boolean updateMeal (@RequestBody TrainingDB trainingDB){
        return TrainingS.updateTraining(trainingDB);
    }

    @DeleteMapping("/delete/{id}")
    public String delete (@PathVariable int id){
        return TrainingS.deleteTrainingById(id);
    }
}
