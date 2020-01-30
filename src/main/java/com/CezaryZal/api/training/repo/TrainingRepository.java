package com.CezaryZal.api.training.repo;

import com.CezaryZal.api.training.model.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {

    Optional<List<Training>> findAllByDayId(Long dayId);
}
