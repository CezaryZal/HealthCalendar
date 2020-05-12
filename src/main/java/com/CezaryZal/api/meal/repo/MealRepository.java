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

    @Query(value = "SELECT * FROM meal m INNER JOIN day d ON m.day_id =d.id WHERE m.day_id=:inputDayId " +
            "AND d.user_id=:inputUserId", nativeQuery = true)
    Optional<List<Meal>> findAllByDayIdAndUserId(@Param("inputDayId") Long dayId, @Param("inputUserId") Long userId);

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

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE meal m INNER JOIN day d ON m.day_id=d.id SET m.date_time=:dateTimeOfEat, " +
            "m.type=:type, m.kcal=:kcal, m.description=:description WHERE m.id=:mealId AND d.user_id=:userId",
            nativeQuery = true)
    void updateMeal(@Param("mealId") Long mealId,
                    @Param("dateTimeOfEat") LocalDateTime dateTimeOfEat,
                    @Param("type") String type,
                    @Param("kcal") int kcal,
                    @Param("description") String description,
                    @Param("userId") Long userId);

    @Modifying
    @Query(value = "DELETE m FROM meal m, day d WHERE m.day_id = d.id AND m.id=:inputId AND d.user_id=:inputUserId",
            nativeQuery = true)
    void deleteByIdAndUserID(@Param("inputId") Long id, @Param("inputUserId") Long userId);


}
