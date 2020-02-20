package com.CezaryZal.api.body.repo;

import com.CezaryZal.api.body.model.entity.BodySize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BodySizeRepository extends JpaRepository<BodySize, Long> {

    @Query(value = "SELECT date FROM body_size WHERE user_id =:userId ORDER BY date DESC LIMIT 1", nativeQuery = true)
    Optional<Date> findDateLastMeasureByUserId(@Param("userId") Long userId);

    @Query(value = "SELECT date FROM body_size WHERE user_id =:userId", nativeQuery = true)
    Optional<List<Date>> findByUserIdAllDate(@Param("userId") Long userId);

    Optional<BodySize> findByDateMeasurementAndUserId(LocalDate localDate, Long userId);

    List<BodySize> findAllByUserId(Long userId);

}
