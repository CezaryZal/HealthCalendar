package com.CezaryZal.api.limits;

import com.CezaryZal.exceptions.DailyLimitsNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DailyLimitsService {

    private DailyLimitsRepository DailyLimitsR;

    public DailyLimitsService(DailyLimitsRepository dailyLimitsR) {
        DailyLimitsR = dailyLimitsR;
    }

    public DailyLimits getLimitsById(Long id){
        return DailyLimitsR.findById(id)
                .orElseThrow(() -> new DailyLimitsNotFoundException("Daily limits not found by id"));
    }

    public DailyLimits getLimitsByUserId(Long id){
        return DailyLimitsR.findByUserId(id)
                .orElseThrow(() -> new DailyLimitsNotFoundException("Daily limits not found by user id"));
    }

    public List<DailyLimits> getAll(){
        return (List<DailyLimits>) DailyLimitsR.findAll();
    }

    public void addLimits (DailyLimits dailyLimits){
        DailyLimitsR.save(dailyLimits);
    }

    public void updateLimits (DailyLimits dailyLimits){
        DailyLimitsR.save(dailyLimits);
    }

    public void deleteLimitsById (Long id){
        DailyLimitsR.deleteById(id);
    }
}
