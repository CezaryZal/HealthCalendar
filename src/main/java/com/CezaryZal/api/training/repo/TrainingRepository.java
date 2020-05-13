package com.CezaryZal.api.training.repo;

import com.CezaryZal.api.training.model.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {

    @Query(value = "SELECT * FROM training t INNER JOIN day d ON t.day_id=d.id " +
            "WHERE t.day_id=:inputDayId AND d.user_id=:inputUserId", nativeQuery = true)
    Optional<List<Training>> findTrainingListByDayIdAndUserId(@Param("inputDayId") Long dayId,
                                                              @Param("inputUserId") Long userId);

    @Query(value = "SELECT * FROM training WHERE day_id =:inputDayId", nativeQuery = true)
    List<Training> findTrainingListByDayId(@Param("inputDayId") Long dayId);

    @Query(value = "SELECT * FROM training t INNER JOIN day d ON t.day_id=d.id " +
            "WHERE d.date=:inputDate AND d.user_id=:inputUserId", nativeQuery = true)
    List<Training> findTrainingListByDateAndUserId(@Param("inputDate") LocalDate inputDate,
                                                   @Param("inputUserId") Long userId);

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE training t INNER JOIN day d ON t.day_id=d.id SET t.date_time=:dateTimeOfEat, " +
            "t.time=:elapsedTime, t.burn_kcal=:burnKcal, t.description=:description " +
            "WHERE t.id=:trainingId AND d.user_id=:userId", nativeQuery = true)
    void updateTraining(@Param("trainingId") Long trainingId,
                        @Param("dateTimeOfEat") LocalDateTime dateTimeOfEat,
                        @Param("elapsedTime") LocalTime elapsedTime,
                        @Param("burnKcal") int burnKcal,
                        @Param("description") String description,
                        @Param("userId") Long userId);

    @Modifying(clearAutomatically = true)
    @Query(value = "DELETE t FROM training t INNER JOIN day d ON t.day_id=d.id AND t.id=:inputId " +
            "AND d.user_id=:inputUserId", nativeQuery = true)
    void deleteByIdAndUserID(@Param("inputId") Long trainingId, @Param("inputUserId") Long userId);
}
