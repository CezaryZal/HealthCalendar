package com.CezaryZal.training;

import com.CezaryZal.training.trainingsByDay.AllTrainingsByDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/training")
public class TrainingController {

    private TrainingService TService;

    @Autowired
    public TrainingController(TrainingService TService) {
        this.TService = TService;
    }

    @GetMapping("/id/{nrId}")
    public TrainingDB getMealById (@PathVariable int nrId){
        return TService.findById(nrId);
    }

    @GetMapping("/getDietByDateAndDayId/{date}/{dayId}")
    public AllTrainingsByDay getListByDateAndDayId(@PathVariable String date, @PathVariable int dayId){
        return TService.getTrainingsByDay(date, dayId);
    }

    @GetMapping("/getAll")
    public List<TrainingDB> getAll(){
        return TService.getAll();
    }

    @PostMapping("/add")
    public boolean addDiet (@RequestBody TrainingDB trainingDB){
        return TService.addTraining(trainingDB);
    }

    @PutMapping("/update")
    public boolean updateMeal (@RequestBody TrainingDB trainingDB){
        return TService.updateTraining(trainingDB);
    }

    @DeleteMapping("/delete/{id}")
    public String delete (@PathVariable int id){
        return TService.deleteTrainingById(id);
    }
}
