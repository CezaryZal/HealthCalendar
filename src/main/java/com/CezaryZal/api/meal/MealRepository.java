package com.CezaryZal.api.meal;

import com.CezaryZal.api.meal.model.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {

    Optional<List<Meal>> findAllByDayId(Long dayId);

    @Query(value = "select sum(kcal) from meal where day_id =:inputDayId", nativeQuery = true)
    Optional<Integer> getKcal(@Param("inputDayId") Long userId);

}
