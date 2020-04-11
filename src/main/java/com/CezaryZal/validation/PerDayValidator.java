package com.CezaryZal.validation;

import java.time.LocalDate;

public interface PerDayValidator {

    boolean hasMaxNumberOfModelsPerDay(LocalDate localDate, Long userId);
}
