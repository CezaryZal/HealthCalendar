package com.CezaryZal.validation;

import java.time.LocalDateTime;

public interface OverlappingDataValidator {

    boolean isOverlappingIdsByDate(LocalDateTime inputDateTime, Long firstId, Long secondId);
}
