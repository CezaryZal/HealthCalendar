package com.CezaryZal.dailyLimits;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class DailyLimitsService {

    private DailyLimitsRepository DLRepository;

    @Autowired
    public DailyLimitsService(DailyLimitsRepository DLRepository) {
        this.DLRepository = DLRepository;
    }

    public DailyLimits getLimitsById(int id){
        DailyLimits dailyLimits = DLRepository.findById(id);

        return dailyLimits;
    }

    public DailyLimits getLimitsByUserId(int id){
        DailyLimits dailyLimits = DLRepository.findByUserId(id);

        return dailyLimits;
    }

    public List<DailyLimits> getAll(){
        List<DailyLimits> listLimits = DLRepository.getAll();

        return listLimits;
    }

    public boolean addLimits (DailyLimits dailyLimits){
        DLRepository.save(dailyLimits);

        return true;
    }

    public boolean updateLimits (DailyLimits dailyLimits){
        DLRepository.update(dailyLimits);

        return true;
    }

    public String deleteLimitsById (int id){
        DailyLimits dailyLimits = DLRepository.findById(id);
        if(DLRepository.delete(dailyLimits)){
            return "delete record";
        }
        return "Daily limits id not found";
    }

}
