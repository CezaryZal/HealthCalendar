package com.CezaryZal.production.admin.controllers;

import com.CezaryZal.api.ApiEntityService;
import com.CezaryZal.api.meal.model.MealDto;
import com.CezaryZal.api.meal.manager.MealService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags = "Admin meal controller")
@RestController
@RequestMapping("/admin/api/meal")
public class AdminMealController {

    private final ApiEntityService mealService;

    @Autowired
    public AdminMealController(MealService mealService) {
        this.mealService = mealService;
    }

    @ApiOperation(value = "This will get a `Meal` by id")
    @GetMapping("/{id}")
    public ResponseEntity<MealDto> getMealDtoById (@PathVariable Long id){
        return new ResponseEntity<>((MealDto)mealService.getModelDtoByModelId(id), HttpStatus.OK);
    }

    @ApiOperation(value = "This will get a list `Meal`, all records")
    @GetMapping
    public ResponseEntity<List<MealDto>> getListMealDto(){
        return new ResponseEntity<>(
                mealService.getModelsDtoByModelId().stream()
                                        .map(apiEntityDto -> (MealDto)apiEntityDto)
                                        .collect(Collectors.toList()),
                HttpStatus.OK);
    }
}
