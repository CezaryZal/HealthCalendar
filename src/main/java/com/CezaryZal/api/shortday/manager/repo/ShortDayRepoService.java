package com.CezaryZal.api.shortday.manager.repo;

import com.CezaryZal.api.shortday.ShortDayRepository;
import com.CezaryZal.api.shortday.entity.ShortDay;
import com.CezaryZal.exceptions.not.found.ShortDayNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;


public class ShortDayRepoService {

    private ShortDayRepository shortDayRepository;

    @Autowired
    public ShortDayRepoService(ShortDayRepository shortDayRepository) {
        this.shortDayRepository = shortDayRepository;
    }

    public ShortDay getShortDayById(Long id) {
        return shortDayRepository.findById(id)
                .orElseThrow(() -> new ShortDayNotFoundException("Short day not found by id"));
    }

    public List<ShortDay> getShortsDayByMaxMinDateAndUserId(LocalDate localDateMin, LocalDate localDateMax, Long userId) {
        return shortDayRepository.findAllByUserIdAndDateBetween(userId, localDateMin, localDateMax);
    }

    public List<ShortDay> getAll() {
        return shortDayRepository.findAll();
    }

    public void addShortDay(ShortDay shortDay) {
        shortDayRepository.save(shortDay);
    }

    public void updateShortDay(ShortDay shortDay) {
        shortDayRepository.save(shortDay);
    }

    public void deleteShortDayById(Long id) {
        shortDayRepository.deleteById(id);
    }
}
