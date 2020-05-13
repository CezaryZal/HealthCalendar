package com.CezaryZal.api.training.repo;

import com.CezaryZal.api.training.model.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {

    @Query(value = "SELECT * FROM training t INNER JOIN day d ON t.day_id=d.id " +
            "WHERE t.day_id=:inputDayId AND d.user_id=:inputUserId", nativeQuery = true)
    Optional<List<Training>> findTrainingListByDayIdAndUserId(@Param("inputDayId") Long dayId,
                                                             @Param("inputUserId") Long userId);

    @Query(value = "SELECT * FROM training WHERE day_id =:inputDayId", nativeQuery = true)
    List<Training> findTrainingListByDayId(@Param("inputDayId") Long dayId);

    @Query(value = "SELECT * FROM training t INNER JOIN day d ON t.day_id=d.id " +
            "WHERE t.date_time>=:startDateTime AND t.date_time<=:endDateTime AND d.user_id=:inputUserId",
            nativeQuery = true)
    List<Training> findTrainingListByDateAndUserId(@Param("startDateTime") LocalDateTime startDateTimeOfExecution,
                                                   @Param("endDateTime") LocalDateTime endDateTimeOfExecution,
                                                   @Param("inputUserId") Long userId);


}
