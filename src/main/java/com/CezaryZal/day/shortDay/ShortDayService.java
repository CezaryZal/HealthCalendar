package com.CezaryZal.day.shortDay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Transactional
@Service
public class ShortDayService {

    private ShortDayRepository shortDayR;

    @Autowired
    public ShortDayService(ShortDayRepository shortDayR) {
        this.shortDayR = shortDayR;
    }

    public ShortDay getShortDayById (int id){
        ShortDay shortDay = shortDayR.findById(id);

        return shortDay;
    }

    public List<ShortDay> getShortDaysByDateAndUserId(String inputDate, int userId){
        LocalDate localDateMin = LocalDate.parse(inputDate).minusDays(30);
        LocalDate localDateMax = LocalDate.parse(inputDate).plusDays(30);
        List<ShortDay> listShortDay = shortDayR.findByDateAndUserId(localDateMin, localDateMax, userId);

        return listShortDay;
    }



    public List<ShortDay> getAll(){
        List<ShortDay> listShortDay = shortDayR.getAll();

        return listShortDay;
    }

    public boolean updateShortDay (ShortDay shortDay){
        shortDayR.update(shortDay);

        return true;
    }

    public boolean addShortDay (ShortDay shortDay){
        shortDayR.save(shortDay);

        return true;
    }

    public String deleteShortDayById (int id) {
        ShortDay shortDay = shortDayR.findById(id);
        if (shortDayR.delete(shortDay)){
            return "delete record";
        }
        return "Body size id not found";
    }
}
