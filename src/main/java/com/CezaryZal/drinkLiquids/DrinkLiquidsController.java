package com.CezaryZal.drinkLiquids;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/drink")
public class DrinkLiquidsController {

    private DrinkLiquidsService drinkLiquidsService;

    @Autowired
    public DrinkLiquidsController(DrinkLiquidsService drinkLiquidsService) {
        this.drinkLiquidsService = drinkLiquidsService;
    }

    @GetMapping("/id/{drinkId}")
    public DrinkLiquids getDrinkLiquids (@PathVariable int drinkId){
        DrinkLiquids drinkLiquids = drinkLiquidsService.getDrinkLiquids(drinkId);

        return drinkLiquids;
    }
}
