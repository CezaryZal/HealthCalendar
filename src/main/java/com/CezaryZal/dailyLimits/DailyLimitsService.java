package com.CezaryZal.dailyLimits;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class DailyLimitsService {

    private DailyLimitsRepository DailyLimitsR;

    @Autowired
    public DailyLimitsService(DailyLimitsRepository dailyLimitsR) {
        DailyLimitsR = dailyLimitsR;
    }


    public DailyLimits getLimitsById(int id){
        DailyLimits dailyLimits = DailyLimitsR.findById(id);

        return dailyLimits;
    }

    public DailyLimits getLimitsByUserId(int id){
        DailyLimits dailyLimits = DailyLimitsR.findByUserId(id);

        return dailyLimits;
    }

    public List<DailyLimits> getAll(){
        List<DailyLimits> listLimits = DailyLimitsR.getAll();

        return listLimits;
    }

    public boolean addLimits (DailyLimits dailyLimits){
        DailyLimitsR.save(dailyLimits);

        return true;
    }

    public boolean updateLimits (DailyLimits dailyLimits){
        DailyLimitsR.update(dailyLimits);

        return true;
    }

    public String deleteLimitsById (int id){
        DailyLimits dailyLimits = DailyLimitsR.findById(id);
        if(DailyLimitsR.delete(dailyLimits)){
            return "delete record";
        }
        return "Daily limits id not found";
    }

}
