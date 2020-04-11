package com.CezaryZal.validation.validator;

import com.CezaryZal.api.day.repo.DayRepository;
import com.CezaryZal.validation.OverlappingDataValidator;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class IdsByDateOverlappingDataValidator implements OverlappingDataValidator {

    private DayRepository dayRepository;

    public IdsByDateOverlappingDataValidator(DayRepository dayRepository) {
        this.dayRepository = dayRepository;
    }

    @Override
    public boolean isOverlappingIdsByDate(LocalDateTime inputDateTime, Long dayId, Long userId) {
        Long dayIdByDateAndUserId =
                dayRepository.getDayIdByDateAndUserId(LocalDate.from(inputDateTime), userId)
                        .orElse(0L);
        return dayIdByDateAndUserId.equals(dayId);
    }
}
