package com.CezaryZal.api.limits.manager;

import com.CezaryZal.api.limits.entity.DailyLimits;
import com.CezaryZal.api.limits.entity.DailyLimitsDto;
import com.CezaryZal.api.limits.manager.mapper.DailyLimitsToDtoConverter;
import com.CezaryZal.api.limits.manager.mapper.DtoToDailyLimitsConverter;
import com.CezaryZal.api.limits.manager.repo.DailyLimitsRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DailyLimitsService{

    private final DailyLimitsRepoService dailyLimitsRepoService;
    private final DailyLimitsToDtoConverter dailyLimitsToDtoConverter;
    private final DtoToDailyLimitsConverter dtoToDailyLimitsConverter;

    @Autowired
    public DailyLimitsService(DailyLimitsRepoService dailyLimitsRepoService,
                              DailyLimitsToDtoConverter dailyLimitsToDtoConverter,
                              DtoToDailyLimitsConverter dtoToDailyLimitsConverter) {
        this.dailyLimitsRepoService = dailyLimitsRepoService;
        this.dailyLimitsToDtoConverter = dailyLimitsToDtoConverter;
        this.dtoToDailyLimitsConverter = dtoToDailyLimitsConverter;
    }

    public DailyLimitsDto getLimitsDtoById(Long id){
        return dailyLimitsToDtoConverter.mappingEntity(dailyLimitsRepoService.getLimitById(id));
    }

    public DailyLimitsDto getLimitsDtoByUserId(Long id){
        return dailyLimitsToDtoConverter.mappingEntity(dailyLimitsRepoService.getLimitsByUserId(id));
    }

    public List<DailyLimitsDto> getListLimitsDto(){
        List<DailyLimits> allDailyLimits = dailyLimitsRepoService.getListLimits();
        return allDailyLimits.stream()
                .map(dailyLimitsToDtoConverter::mappingEntity)
                .collect(Collectors.toList());
    }

    public String updateDailyLimits (DailyLimitsDto dailyLimitsDto){
        dailyLimitsRepoService.updateLimits(dtoToDailyLimitsConverter.mappingEntity(dailyLimitsDto));
        return "Przesłane limity zostały uaktualnione";
    }
}
