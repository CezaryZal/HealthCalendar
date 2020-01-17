package com.CezaryZal.api.shortday;

import com.CezaryZal.api.shortday.entity.ShortDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ShortDayRepository extends JpaRepository<ShortDay, Long> {

    List<ShortDay> findAllByUserIdAndDateBetween(Long userId, LocalDate localDateMin, LocalDate localDateMax);
}
