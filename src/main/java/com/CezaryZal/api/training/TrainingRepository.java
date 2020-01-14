package com.CezaryZal.api.training;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingRepository extends CrudRepository<Training, Long> {

    List<Training> findAllByDayId(Long dayId);
}
