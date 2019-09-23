package com.CezaryZal.drinkLiquids;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class DrinkLiquidsService {

    private DrinkLiquidsRepository drinkRepository;

    @Autowired
    public DrinkLiquidsService(DrinkLiquidsRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    public DrinkLiquids getDrinkLiquids (int id){
        return drinkRepository.getDrinkLiquids(id);
    }
}
