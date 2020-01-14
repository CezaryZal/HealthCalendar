package com.CezaryZal.api.shortday;

import com.CezaryZal.exceptions.ShortDayNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ShortDayService {

    private ShortDayRepository shortDayR;

    public ShortDayService(ShortDayRepository shortDayR) {
        this.shortDayR = shortDayR;
    }

    public ShortDay getShortDayById(Long id) {
        return shortDayR.findById(id)
                .orElseThrow(() -> new ShortDayNotFoundException("Short day not found by id"));
    }

    public List<ShortDay> getShortDaysByDateAndUserId(String inputDate, Long userId) {
        LocalDate localDateMin = LocalDate.parse(inputDate).minusDays(30);
        LocalDate localDateMax = LocalDate.parse(inputDate).plusDays(30);
        List<ShortDay> listShortDay = shortDayR.findAllByUserIdAndDateBetween(userId, localDateMin, localDateMax);

        return listShortDay;
    }

    public List<ShortDay> getAll() {
        return (List<ShortDay>) shortDayR.findAll();
    }

    public void updateShortDay(ShortDay shortDay) {
        shortDayR.save(shortDay);
    }

    public void addShortDay(ShortDay shortDay) {
        shortDayR.save(shortDay);
    }

    public void deleteShortDayById(Long id) {
        shortDayR.deleteById(id);
    }
}
