package com.CezaryZal.api.day.repo;

import com.CezaryZal.api.day.model.entity.Day;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface DayRepository extends JpaRepository<Day, Long> {

    @Query(value = "SELECT id FROM day WHERE date =:inputDate AND user_id =:userId", nativeQuery = true)
    Optional<Long> getDayIdByDateAndUserId(@Param("inputDate") LocalDate localDate, @Param("userId") Long userId);

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE day SET portions_alcohol=:portionsAlco, portions_drink=:portionsDrink, " +
            "portions_snack=:portionsSnack WHERE id =:dayId", nativeQuery = true)
    void updateDay(@Param("portionsAlco") int portionsAlcohol,
                   @Param("portionsDrink") int portionsDrink,
                   @Param("portionsSnack") int portionsSnack,
                   @Param("dayId") Long dayId);

    Optional<Day> findDayByDateAndUserId(LocalDate localDate, Long userId);

    List<Day> findDaysByUserId(Long userId);
}
