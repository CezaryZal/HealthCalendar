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
    Optional<LimitsCleanDate> getLimitsCleanDate(@Param("inputUserId") Long userId);

    @Query(value = "select daily_limits.id from daily_limits, user where daily_limits.id = user.daily_limits_id AND " +
            "user.id=:inputUserId ", nativeQuery = true)
    Optional<Long> getLimitsIdByUserId(@Param("inputUserId") Long userId);

}
