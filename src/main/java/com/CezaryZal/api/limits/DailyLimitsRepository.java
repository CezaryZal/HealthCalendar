package com.CezaryZal.api.limits;

import com.CezaryZal.api.limits.model.LimitsCleanDate;
import com.CezaryZal.api.limits.model.entity.DailyLimits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DailyLimitsRepository extends JpaRepository<DailyLimits, Long> {

    Optional<DailyLimits> findByUserId(Long dayId);

    @Query(name = "Result_for_daily_limits", nativeQuery = true)
    LimitsCleanDate getLimitsCleanDate(@Param("inputUserId") Long userId);

}
