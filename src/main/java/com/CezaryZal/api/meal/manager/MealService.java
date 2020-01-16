package com.CezaryZal.api.meal.manager;

import com.CezaryZal.api.meal.MealRepository;
import com.CezaryZal.api.meal.entity.DailyDietDTO;
import com.CezaryZal.api.meal.entity.Meal;
import com.CezaryZal.api.meal.entity.MealDto;
import com.CezaryZal.api.meal.manager.mapper.MealToDtoConverter;
import com.CezaryZal.api.meal.manager.repo.MealRepoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MealService extends MealRepoService {

    private final MealToDtoConverter mealToDtoConverter;

    public MealService(MealRepository mealRepository, MealToDtoConverter mealToDtoConverter) {
        super(mealRepository);
        this.mealToDtoConverter = mealToDtoConverter;
    }

    public MealDto getMealDtoById(Long id) {
        return mealToDtoConverter.mappingEntity(findMealById(id));
    }

    public DailyDietDTO getDailyDietDTOByDayId(Long dayId) {
        List<Meal> listMeals = getListMealByDayId(dayId);

        return createDailyDietDTO(listMeals);
    }

    public List<MealDto> getListMealDto() {
        List<Meal> meals = getAll();
        return meals.stream()
                .map(mealToDtoConverter::mappingEntity)
                .collect(Collectors.toList());
    }

    public String addMealByDto(Meal meal) {
        addMeal(meal);
        return "Przesłany posiłek został zapisany w bazie danych";
    }

    public String updateMealByDto(Meal meal) {
        updateMeal(meal);
        return "Przesłane posiłek zostały uaktualnione";
    }

    public String deleteById(Long id) {
        deleteMealById(id);
        return "Posiłek o przesłanym id został usuniety";
    }

    public DailyDietDTO createDailyDietDTO(List<Meal> listMeals) {
        int sumOfKcal = 0;
        for (Meal meal : listMeals) {
            sumOfKcal += meal.getKcal();
        }
        return new DailyDietDTO(listMeals, sumOfKcal);
    }
}
