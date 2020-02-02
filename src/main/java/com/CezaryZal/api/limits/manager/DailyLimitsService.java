package com.CezaryZal.api.limits.manager;

import com.CezaryZal.api.limits.model.LimitsCleanDate;
import com.CezaryZal.api.limits.model.entity.DailyLimits;
import com.CezaryZal.api.limits.model.DailyLimitsDto;
import com.CezaryZal.api.limits.repo.DailyLimitsRepository;
import com.CezaryZal.api.user.model.AccountEntity;
import com.CezaryZal.constants.DefaultLimitsCleanDate;
import com.CezaryZal.exceptions.not.found.DailyLimitsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DailyLimitsService{

    private final DailyLimitsRepository limitsRepository;
    private final DailyLimitsConverter dailyLimitsConverter;
    private final DailyLimitsCreator dailyLimitsCreator;
    private final DefaultLimitsCleanDate defaultLimitsCleanDate;

    @Autowired
    public DailyLimitsService(DailyLimitsRepository limitsRepository,
                              DailyLimitsConverter dailyLimitsConverter,
                              DailyLimitsCreator dailyLimitsCreator,
                              DefaultLimitsCleanDate defaultLimitsCleanDate) {
        this.limitsRepository = limitsRepository;
        this.dailyLimitsConverter = dailyLimitsConverter;
        this.dailyLimitsCreator = dailyLimitsCreator;
        this.defaultLimitsCleanDate = defaultLimitsCleanDate;
    }

    public DailyLimitsDto getLimitsDtoById(Long id){
        DailyLimits dailyLimits = limitsRepository.findById(id)
                .orElseThrow(() -> new DailyLimitsNotFoundException("Daily limits not found by id"));
        return dailyLimitsConverter.mappingDailyLimitsToDto(dailyLimits);
    }

    public DailyLimitsDto getLimitsDtoByUserId(Long userId){
        DailyLimits dailyLimits = limitsRepository.getLimitsByUserId(userId)
                .orElseThrow(() -> new DailyLimitsNotFoundException("Daily limits not found by user id"));
        return dailyLimitsConverter.mappingDailyLimitsToDto(dailyLimits);
    }

    public DailyLimits convertAccountEntityToDailyLimits(AccountEntity accountEntity){
        return dailyLimitsConverter.mappingAccountEntityToDailyLimits(accountEntity);
    }

    public Long getLimitsId(Long userId){
        return limitsRepository.getLimitsIdByUserId(userId)
                .orElseThrow(() -> new DailyLimitsNotFoundException("Id not found by user id"));
    }

    public LimitsCleanDate getLimitsCleanDateByUserId(Long id){
        return limitsRepository.getLimitsCleanDate(id)
                .orElseGet(defaultLimitsCleanDate::getDefaultLimitsCleanDate);
    }

    public List<DailyLimitsDto> getListLimitsDto(){
        List<DailyLimits> allDailyLimits = limitsRepository.findAll();
        return allDailyLimits.stream()
                .map(dailyLimitsConverter::mappingDailyLimitsToDto)
                .collect(Collectors.toList());
    }

    public String updateDailyLimits (DailyLimitsDto dailyLimitsDto, Long limitsId){
        limitsRepository.save(dailyLimitsCreator.createLimitsToUpdateByDtoAndId(dailyLimitsDto, limitsId));
        return "Przesłane limity zostały uaktualnione";
    }





}
