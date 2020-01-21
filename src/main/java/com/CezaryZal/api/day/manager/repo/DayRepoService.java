package com.CezaryZal.api.day.manager.repo;

import com.CezaryZal.api.day.DayRepository;
import com.CezaryZal.api.day.model.entity.Day;
import com.CezaryZal.exceptions.not.found.DayNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DayRepoService {

    private final DayRepository dayRepository;

    @Autowired
    public DayRepoService(DayRepository dayRepository) {
        this.dayRepository = dayRepository;
    }

    public Day getDayById(Long id) {
        return dayRepository.findById(id)
                .orElseThrow(() -> new DayNotFoundException("Day not found by id"));
    }

    public Long getDayIdByDateAndUserId(String inputDate, Long userId) {
        return dayRepository.getDayIdByDateAndUserId(LocalDate.parse(inputDate), userId)
                .orElseThrow(() -> new DayNotFoundException("Id day not found by date and user id"));
    }

    public Day getDayByDateAndUserId(String inputDate, Long userId) {
        return dayRepository.findDayByDateAndUserId(LocalDate.parse(inputDate), userId)
                .orElseThrow(() -> new DayNotFoundException("Day not found by date and user id"));
    }

    public List<Day> getAll() {
        return dayRepository.findAll();
    }

    public void addDay(Day day) {
        dayRepository.save(day);
    }

    public void updateDay(Day day) {
        dayRepository.save(day);
    }

    public void deleteDayById(Long id) {
        dayRepository.deleteById(id);
    }

}
