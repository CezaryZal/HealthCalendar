package com.CezaryZal.api.shortReport;

import com.CezaryZal.api.shortReport.entity.ShortReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ShortReportRepository extends JpaRepository<ShortReport, Long> {

    Optional<ShortReport> findByDateAndUserId(LocalDate localDate, Long userId);

    List<ShortReport> findAllByUserIdAndDateBetween(Long userId, LocalDate localDateMin, LocalDate localDateMax);
}
