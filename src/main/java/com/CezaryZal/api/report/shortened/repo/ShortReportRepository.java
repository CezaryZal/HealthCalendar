package com.CezaryZal.api.report.shortened.repo;

import com.CezaryZal.api.report.shortened.model.entity.ShortReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ShortReportRepository extends JpaRepository<ShortReport, Long> {

    @Query(value = "SELECT short_report.id FROM short_report, day WHERE short_report.id = day.short_day_id AND " +
            "short_report.date=:inputDate and day.user_id=:inputUserId",
            nativeQuery = true)
    Optional<Long> getIdByDateAndUserId(
            @Param("inputDate") LocalDate localDate,
            @Param("inputUserId") Long userId);

    @Query(value = "SELECT * FROM short_report, day WHERE short_report.id = day.short_day_id AND " +
            "day.user_id=:inputUserId AND short_report.date=:inputDate",
            nativeQuery = true)
    Optional<ShortReport> findShortReportByDateAndUserId(
            @Param("inputDate")LocalDate localDate,
            @Param("inputUserId") Long userId);

    @Query(value = "SELECT * FROM short_report, day WHERE short_report.id = day.short_day_id AND " +
            "day.user_id=:inputUserId AND short_report.date<=:dateMax AND short_report.date>=:dateMin",
            nativeQuery = true)
    List<ShortReport> findShortDayByUserIdAndMonthForwardAndBackward(
            @Param("inputUserId") Long userId,
            @Param("dateMin")LocalDate localDateMin,
            @Param("dateMax")LocalDate localDateMax);
}
