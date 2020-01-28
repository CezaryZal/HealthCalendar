package com.CezaryZal.api.limits.manager;

import com.CezaryZal.api.limits.model.entity.DailyLimits;
import com.CezaryZal.api.limits.model.DailyLimitsDto;
import com.CezaryZal.api.limits.manager.mapper.DailyLimitsConverter;
import com.CezaryZal.api.limits.manager.repo.DailyLimitsRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DailyLimitsService{

    private final DailyLimitsRepoService dailyLimitsRepoService;
    private final DailyLimitsConverter dailyLimitsConverter;
    private final LimitsCreator limitsCreator;

    @Autowired
    public DailyLimitsService(DailyLimitsRepoService dailyLimitsRepoService,
                              DailyLimitsConverter dailyLimitsConverter,
                              LimitsCreator limitsCreator) {
        this.dailyLimitsRepoService = dailyLimitsRepoService;
        this.dailyLimitsConverter = dailyLimitsConverter;
        this.limitsCreator = limitsCreator;
    }

    public DailyLimitsDto getLimitsDtoById(Long id){
        return dailyLimitsConverter.mappingDailyLimitsToDto(dailyLimitsRepoService.getLimitById(id));
    }

    public DailyLimitsDto getLimitsDtoByUserId(Long id){
        return dailyLimitsConverter.mappingDailyLimitsToDto(dailyLimitsRepoService.getLimitsByUserId(id));
    }

    public List<DailyLimitsDto> getListLimitsDto(){
        List<DailyLimits> allDailyLimits = dailyLimitsRepoService.getListLimits();
        return allDailyLimits.stream()
                .map(dailyLimitsConverter::mappingDailyLimitsToDto)
                .collect(Collectors.toList());
    }

    public String updateDailyLimits (DailyLimitsDto dailyLimitsDto, Long limitsId){
        dailyLimitsRepoService.updateLimits(limitsCreator.createToUpdateByDtoAndId(dailyLimitsDto, limitsId));
        return "Przesłane limity zostały uaktualnione";
    }
}
