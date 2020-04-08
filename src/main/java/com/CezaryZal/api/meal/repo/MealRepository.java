package com.CezaryZal.api.meal.repo;

import com.CezaryZal.api.meal.model.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {

    Optional<List<Meal>> findAllByDayId(Long dayId);

    @Query(value = "SELECT * FROM meal WHERE day_id =:inputDayId", nativeQuery = true)
    List<Meal> findMealListByDayId(@Param("inputDayId") Long dayId);

    @Query(value = "SELECT * FROM meal m, day d WHERE m.day_id =d.id AND d.user_id=:inputUserId AND d.date=:inputDate",
            nativeQuery = true)
    List<Meal> findMealListByDateAndUserId(@Param("inputDate") LocalDate date, @Param("inputUserId") Long userId);

    @Query(value = "SELECT SUM(kcal) FROM meal WHERE day_id =:inputDayId", nativeQuery = true)
    Optional<Integer> getKcal(@Param("inputDayId") Long dayId);

    @Query(value = "SELECT COUNT(m.id) FROM meal m, day d WHERE " +
            "m.day_id =d.id AND d.date=:inputDate AND d.user_id=:inputUserId", nativeQuery = true)
    int getNumberOfMealsContainedOnDay(@Param("inputDate") LocalDate date, @Param("inputUserId") Long userId);

    @Modifying
    @Query(value = "DELETE m FROM meal m, day d WHERE m.day_id = d.id AND m.id=:inputId AND d.user_id=:inputUserId",
            nativeQuery = true)
    void deleteByIdAndUserID(@Param("inputId") Long id, @Param("inputUserId") Long userId);


}
