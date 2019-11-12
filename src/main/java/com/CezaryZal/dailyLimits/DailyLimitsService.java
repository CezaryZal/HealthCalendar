package com.CezaryZal.dailyLimits;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Transactional
@Service
public class DailyLimitsService {

    private DailyLimitsRepository DailyLimitsR;

    @Autowired
    public DailyLimitsService(DailyLimitsRepository dailyLimitsR) {
        DailyLimitsR = dailyLimitsR;
    }


    public DailyLimits getLimitsById(int id){
        return DailyLimitsR.findById(id);
    }

    public DailyLimits getLimitsByUserId(int id){
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

    public String deleteLimitsById (int id){
        DailyLimits dailyLimits = DailyLimitsR.findById(id);
        if(DailyLimitsR.delete(dailyLimits)){
            return "delete record";
        }
        return "Daily limits id not found";
    }
}
