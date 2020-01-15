package com.CezaryZal.api.limits.manager;

import com.CezaryZal.api.limits.DailyLimitsRepository;
import com.CezaryZal.api.limits.entity.DailyLimits;
import com.CezaryZal.api.limits.entity.DailyLimitsDto;
import com.CezaryZal.api.limits.manager.mapper.DailyLimitsToDtoConverter;
import com.CezaryZal.api.limits.manager.repo.DailyLimitsRepoService;
import com.CezaryZal.exceptions.not.found.DailyLimitsNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DailyLimitsService extends DailyLimitsRepoService {

    private final DailyLimitsToDtoConverter dailyLimitsToDtoConverter;

    public DailyLimitsService(DailyLimitsRepository limitsRepository, DailyLimitsToDtoConverter dailyLimitsToDtoConverter) {
        super(limitsRepository);
        this.dailyLimitsToDtoConverter = dailyLimitsToDtoConverter;
    }

    public DailyLimitsDto getLimitsDtoById(Long id){
        return dailyLimitsToDtoConverter.mappingEntity(getLimitById(id));
    }

    public DailyLimitsDto getLimitsDtoByUserId(Long id){
        return dailyLimitsToDtoConverter.mappingEntity(getLimitsByUserId(id));
    }

    public List<DailyLimitsDto> getListLimitsDto(){
        List<DailyLimits> allDailyLimits = getListLimits();
        return allDailyLimits.stream()
                .map(dailyLimitsToDtoConverter::mappingEntity)
                .collect(Collectors.toList());
    }

    public String addDailyLimits (DailyLimits dailyLimits){
        addLimits(dailyLimits);
        return "Przesłany dzienny limit został zapisany w bazie danych";
    }

    public String updateDailyLimits (DailyLimits dailyLimits){
        updateLimits(dailyLimits);
        return "Przesłane limity zostały uaktualnione";
    }

    public String deleteDailyLimitsById (Long id){
        deleteLimitsById(id);
        return "Dzienny limit o przesłanym id został usuniety";
    }
}
