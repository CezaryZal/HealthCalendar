package com.CezaryZal.api.day.manager.repo;

import com.CezaryZal.api.day.DayRepository;
import com.CezaryZal.api.day.entity.day.Day;
import com.CezaryZal.exceptions.not.found.DayNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

public class DayRepoService {

    private final DayRepository dayRepository;

    @Autowired
    public DayRepoService(DayRepository dayRepository) {
        this.dayRepository = dayRepository;
    }

    protected Day getDayById(Long id) {
        return dayRepository.findById(id)
                .orElseThrow(() -> new DayNotFoundException("Day not found by id"));
    }

    public Long getDayIdByDateAndUserId(String inputDate, Long userId) {
        return dayRepository.getDayIdByDateAndUserId(LocalDate.parse(inputDate), userId)
                .orElseThrow(() -> new DayNotFoundException("Id day not found by date and user id"));
    }

    protected Day getDayByDateAndUserId(LocalDate localDate, Long userId) {
        return dayRepository.findDayByDateAndUserId(localDate, userId)
                .orElseThrow(() -> new DayNotFoundException("Day not found by date and user id"));
    }

    protected List<Day> getAll() {
        return dayRepository.findAll();
    }

    protected void addDay(Day day) {
        dayRepository.save(day);
    }

    protected void updateDay(Day day) {
        dayRepository.save(day);
    }

    protected void deleteDayById(Long id) {
        dayRepository.deleteById(id);
    }

}
