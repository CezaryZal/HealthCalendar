package com.CezaryZal.api.meal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealRepository extends CrudRepository<Meal, Long> {

    List<Meal> findAllByDayId(Long dayId);

}
