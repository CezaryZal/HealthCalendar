package com.CezaryZal.dailyLimits;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DailyLimitsService {

    private DailyLimitsRepository DailyLimitsR;

    public DailyLimitsService(DailyLimitsRepository dailyLimitsR) {
        DailyLimitsR = dailyLimitsR;
    }

    public DailyLimits getLimitsById(Long id){
        return DailyLimitsR.findById(id);
    }

    public DailyLimits getLimitsByUserId(Long id){
        return DailyLimitsR.findByUserId(id);
    }

    public List<DailyLimits> getAll(){
        return DailyLimitsR.getAll();
    }

    public boolean addLimits (DailyLimits dailyLimits){
        DailyLimitsR.save(dailyLimits);

        return true;
    }

    public boolean updateLimits (DailyLimits dailyLimits){
        DailyLimitsR.update(dailyLimits);

        return true;
    }

    public String deleteLimitsById (Long id){
        DailyLimits dailyLimits = DailyLimitsR.findById(id);
        if(DailyLimitsR.delete(dailyLimits)){
            return "delete record";
        }
        return "Daily limits id not found";
    }
}
