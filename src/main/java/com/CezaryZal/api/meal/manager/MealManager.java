package com.CezaryZal.api.meal.manager;

import com.CezaryZal.api.meal.model.MealDto;
import com.CezaryZal.api.meal.model.entity.Meal;
import com.CezaryZal.api.structure.ApiManager;
import com.CezaryZal.api.structure.models.FormEntity;
import com.CezaryZal.api.structure.models.FormEntityDto;
import org.springframework.stereotype.Service;

@Service
public class MealManager extends ApiManager {

    public MealManager() {
        apiConverter = new MealConverter();
        apiCreator = new MealCreator();
    }

    @Override
    public MealDto convertDtoByEntity(FormEntity formEntity) {
        return (MealDto) apiConverter.convertDtoByEntity(formEntity);
    }

    @Override
    public Meal createNewEntityByEntityDto(FormEntityDto formEntityDto) {
        return (Meal) apiCreator.createNewEntity(formEntityDto);
    }


}
