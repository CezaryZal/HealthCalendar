package com.CezaryZal.api.limits.manager.repo;

import com.CezaryZal.api.limits.DailyLimitsRepository;
import com.CezaryZal.api.limits.entity.DailyLimits;
import com.CezaryZal.exceptions.not.found.DailyLimitsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DailyLimitsRepoService {

    private final DailyLimitsRepository limitsRepository;

    @Autowired
    public DailyLimitsRepoService(DailyLimitsRepository limitsRepository) {
        this.limitsRepository = limitsRepository;
    }

    public DailyLimits getLimitById(Long id){
        return limitsRepository.findById(id)
                .orElseThrow(() -> new DailyLimitsNotFoundException("Daily limits not found by id"));
    }

    public DailyLimits getLimitsByUserId(Long id){
        return limitsRepository.findByUserId(id)
                .orElseThrow(() -> new DailyLimitsNotFoundException("Daily limits not found by user id"));
    }

    public List<DailyLimits> getListLimits(){
        return limitsRepository.findAll();
    }

    public void addLimits (DailyLimits dailyLimits){
        limitsRepository.save(dailyLimits);
    }

    public void updateLimits (DailyLimits dailyLimits){
        limitsRepository.save(dailyLimits);
    }

    public void deleteLimitsById (Long id){
        limitsRepository.deleteById(id);
    }

}
