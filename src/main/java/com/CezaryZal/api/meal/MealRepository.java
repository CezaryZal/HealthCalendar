package com.CezaryZal.api.meal;

import com.CezaryZal.api.meal.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {

    Optional<List<Meal>> findAllByDayId(Long dayId);

}
