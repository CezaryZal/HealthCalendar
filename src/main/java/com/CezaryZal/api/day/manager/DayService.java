package com.CezaryZal.api.day.manager;

import com.CezaryZal.api.day.model.entity.Day;
import com.CezaryZal.api.day.model.ObjectToSaveDay;
import com.CezaryZal.api.day.model.DayDto;
import com.CezaryZal.api.day.manager.creator.DayCreator;
import com.CezaryZal.api.day.manager.mapper.*;
import com.CezaryZal.api.day.manager.repo.DayRepoService;
import com.CezaryZal.api.report.shortened.manager.creator.ShortReportCreator;
import com.CezaryZal.api.report.shortened.manager.mapper.ShortReportConverter;
import com.CezaryZal.api.report.shortened.model.entity.ShortReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DayService {

    private final DayRepoService dayRepoService;
    private final DayToDtoConverter dayToDtoConverter;
    private final ObjectToSaveDayToDayConverter objectToSaveDayToDayConverter;
    private final ShortReportConverter shortReportConverter;
    private final ShortReportCreator shortReportCreator;
    private final DayCreator dayCreator;

    @Autowired
    public DayService(DayRepoService dayRepoService,
                      DayToDtoConverter dayToDtoConverter,
                      ObjectToSaveDayToDayConverter objectToSaveDayToDayConverter,
                      ShortReportConverter shortReportConverter,
                      ShortReportCreator shortReportCreator,
                      DayCreator dayCreator) {
        this.dayRepoService = dayRepoService;
        this.dayToDtoConverter = dayToDtoConverter;
        this.objectToSaveDayToDayConverter = objectToSaveDayToDayConverter;
        this.shortReportConverter = shortReportConverter;
        this.shortReportCreator = shortReportCreator;
        this.dayCreator = dayCreator;
    }

    public DayDto getDayDtoById(Long id) {
        return dayToDtoConverter.mappingEntity(dayRepoService.getDayById(id));
    }

    public DayDto getDayDtoByDateAndUserId(String inputDate, Long userId) {
        return dayToDtoConverter.mappingEntity(dayRepoService.getDayByDateAndUserId(inputDate, userId));
    }

    public List<DayDto> getDaysDto(){
        return dayRepoService.getAll().stream()
                .map(dayToDtoConverter::mappingEntity)
                .collect(Collectors.toList());
    }

    public String addNewDay(ObjectToSaveDay day){
        ShortReport newShortReport = shortReportConverter.mappingObjectToSaveDayToShortReport(day);
        Day newDay = objectToSaveDayToDayConverter.mappingEntity(day);
        newDay.setShortReport(newShortReport);
        dayRepoService.addDay(newDay);
        return "Dzień z aktualną datą został dodany do bazy danych";
    }

    public String update(ObjectToSaveDay day) {
        ShortReport updatedShortReport = shortReportCreator.createByDay(day);
        dayRepoService.updateDay(dayCreator.createByDayApiAndShortDay(day, updatedShortReport));
        return "Wskazany dzień został aktualizowany wraz ze skrótem";
    }

    public String deleteDay(Long id) {
        dayRepoService.deleteDayById(id);
        return "Dzień o podanym id został usunięty wraz ze skrótem dnia";
    }
}
