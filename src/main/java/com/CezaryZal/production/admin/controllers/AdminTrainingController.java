package com.CezaryZal.production.admin.controllers;

import com.CezaryZal.api.ApiEntityDto;
import com.CezaryZal.api.ApiEntityService;
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

    private final ApiEntityService trainingService;

    @Autowired
    public AdminTrainingController(ApiEntityService trainingService) {
        this.trainingService = trainingService;
    }

    @ApiOperation(value = "This will get a `Training` by id")
    @GetMapping("/{id}")
    public ResponseEntity<ApiEntityDto> getTrainingDtoById (@PathVariable Long id){
        return new ResponseEntity<>(trainingService.getModelDtoByModelId(id), HttpStatus.OK);
    }

    @ApiOperation(value = "This will get a list `Training`, all records")
    @GetMapping
    public ResponseEntity<List<ApiEntityDto>> getAllTrainings(){
        return new ResponseEntity<>(trainingService.getModelsDtoByModelId(), HttpStatus.OK);
    }
}
