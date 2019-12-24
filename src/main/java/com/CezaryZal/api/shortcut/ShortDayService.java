package com.CezaryZal.api.shortcut;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ShortDayService {

    private ShortDayRepository shortDayR;

    public ShortDayService(ShortDayRepository shortDayR) {
        this.shortDayR = shortDayR;
    }

    public ShortDay getShortDayById (Long id){
        return shortDayR.findById(id);
    }

    public List<ShortDay> getShortDaysByDateAndUserId(String inputDate, Long userId){
        LocalDate localDateMin = LocalDate.parse(inputDate).minusDays(30);
        LocalDate localDateMax = LocalDate.parse(inputDate).plusDays(30);
        List<ShortDay> listShortDay = shortDayR.findByDateAndUserId(localDateMin, localDateMax, userId);

        return listShortDay;
    }

    public List<ShortDay> getAll(){
        return shortDayR.getAll();
    }

    public boolean updateShortDay (ShortDay shortDay){
        shortDayR.update(shortDay);

        return true;
    }

    public boolean addShortDay (ShortDay shortDay){
        shortDayR.save(shortDay);

        return true;
    }

    public String deleteShortDayById (Long id) {
        ShortDay shortDay = shortDayR.findById(id);
        if (shortDayR.delete(shortDay)){
            return "delete record";
        }
        return "Body size id not found";
    }
}