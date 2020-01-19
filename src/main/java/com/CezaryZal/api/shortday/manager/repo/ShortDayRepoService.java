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

    protected ShortDay getShortDayById(Long id) {
        return shortDayRepository.findById(id)
                .orElseThrow(() -> new ShortDayNotFoundException("Short day not found by id"));
    }

    public ShortDay getShortDayByDateAndUserId(LocalDate localDate, Long userId) {
        return shortDayRepository.findByDateAndUserId(localDate, userId)
                .orElseThrow(() -> new ShortDayNotFoundException("Short day not found by date and user id"));
    }

    protected List<ShortDay> getShortsDayByMaxMinDateAndUserId(LocalDate localDateMin, LocalDate localDateMax, Long userId) {
        return shortDayRepository.findAllByUserIdAndDateBetween(userId, localDateMin, localDateMax);
    }

    protected List<ShortDay> getAll() {
        return shortDayRepository.findAll();
    }

}