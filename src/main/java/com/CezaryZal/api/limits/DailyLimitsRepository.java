package com.CezaryZal.api.limits;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DailyLimitsRepository extends CrudRepository<DailyLimits, Long> {

    Optional<DailyLimits> findByUserId(Long dayId);

}
