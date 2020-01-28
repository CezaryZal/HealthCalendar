package com.CezaryZal.api.limits.manager.repo;

import com.CezaryZal.api.limits.DailyLimitsRepository;
import com.CezaryZal.api.limits.model.LimitsCleanDate;
import com.CezaryZal.api.limits.model.entity.DailyLimits;
import com.CezaryZal.exceptions.not.found.DailyLimitsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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

    public Long getLimitsId(Long userId){
        return limitsRepository.getLimitsIdByUserId(userId)
                .orElseThrow(() -> new DailyLimitsNotFoundException("Id not found by user id"));
    }

    public LimitsCleanDate getLimitsCleanDateByUserId(Long id){
        return limitsRepository.getLimitsCleanDate(id)
                .orElseGet(() -> new LimitsCleanDate(10000, 100));
    }

    public List<DailyLimits> getListLimits(){
        return limitsRepository.findAll();
    }

    public void updateLimits (DailyLimits dailyLimits){
        limitsRepository.save(dailyLimits);
    }

}
