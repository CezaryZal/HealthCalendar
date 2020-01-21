package com.CezaryZal.api.limits;

import com.CezaryZal.api.limits.model.entity.DailyLimits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DailyLimitsRepository extends JpaRepository<DailyLimits, Long> {

    Optional<DailyLimits> findByUserId(Long dayId);

}
