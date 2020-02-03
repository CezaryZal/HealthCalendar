package com.CezaryZal.api.day.repo;

import com.CezaryZal.api.day.model.entity.Day;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface DayRepository extends JpaRepository<Day, Long> {

    @Query(value = "select id from day where date =:inputDate and user_id =:userId", nativeQuery = true)
    Optional<Long> getDayIdByDateAndUserId(@Param("inputDate") LocalDate localDate, @Param("userId") Long userId);

    Optional<Day> findDayByDateAndUserId(LocalDate localDate, Long userId);

    List<Day> findDaysByUserId(Long userId);
}
