package com.CezaryZal.api.limits.repo;

import com.CezaryZal.api.limits.model.entity.DailyLimits;
import com.CezaryZal.api.report.model.DailyLimitsTmp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DailyLimitsRepository extends JpaRepository<DailyLimits, Long> {

    @Query(value = "SELECT * FROM daily_limits, user WHERE daily_limits.id = user.daily_limits_id AND " +
            "user.id=:inputUserId ", nativeQuery = true)
    Optional<DailyLimits> getLimitsByUserId(@Param("inputUserId") Long userId);

    @Query(name = "Result_for_daily_limits", nativeQuery = true)
    Optional<DailyLimitsTmp> getLimitsCleanDate(@Param("inputUserId") Long userId);

    @Query(value = "SELECT daily_limits.id FROM daily_limits, user WHERE daily_limits.id = user.daily_limits_id AND " +
            "user.id=:inputUserId ", nativeQuery = true)
    Optional<Long> getLimitsIdByUserId(@Param("inputUserId") Long userId);

}
