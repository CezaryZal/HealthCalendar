package com.CezaryZal.production.admin.controllers;

import com.CezaryZal.api.training.model.TrainingDto;
import com.CezaryZal.api.training.manager.TrainingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags = "Admin traning controller")
@RestController
@RequestMapping("/admin/api/training")
public class AdminTrainingController {

    private final TrainingService trainingService;

    @Autowired
    public AdminTrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @ApiOperation(value = "This will get a `Training` by id")
    @GetMapping("/{id}")
    public ResponseEntity<TrainingDto> getTrainingDtoById (@PathVariable Long id){
        return new ResponseEntity<>(trainingService.getTrainingDtoById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "This will get a list `Training`, all records")
    @GetMapping
    public ResponseEntity<List<TrainingDto>> getAllTrainings(){
        return new ResponseEntity<>(trainingService.getAllTrainingsDto(), HttpStatus.OK);
    }
}
