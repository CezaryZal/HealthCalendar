package com.CezaryZal.api.shortday;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ShortDayRepository extends CrudRepository<ShortDay, Long> {

    List<ShortDay> findAllByUserIdAndDateBetween(Long userId, LocalDate localDateMin, LocalDate localDateMax);
}
