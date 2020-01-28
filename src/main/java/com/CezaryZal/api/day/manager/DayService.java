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
    private final DayConverter dayConverter;
    private final ShortReportCreator shortReportCreator;
    private final DayCreator dayCreator;

    @Autowired
    public DayService(DayRepoService dayRepoService,
                      DayConverter dayConverter,
                      ShortReportCreator shortReportCreator,
                      DayCreator dayCreator) {
        this.dayRepoService = dayRepoService;
        this.dayConverter = dayConverter;
        this.shortReportCreator = shortReportCreator;
        this.dayCreator = dayCreator;
    }

    public DayDto getDayDtoById(Long id) {
        return dayConverter.mappingDayToDto(dayRepoService.getDayById(id));
    }

    public DayDto getDayDtoByDateAndUserId(String inputDate, Long userId) {
        return dayConverter.mappingDayToDto(dayRepoService.getDayByDateAndUserId(inputDate, userId));
    }

    public List<DayDto> getDaysDto(){
        return dayRepoService.getAll().stream()
                .map(dayConverter::mappingDayToDto)
                .collect(Collectors.toList());
    }

    public String addNewDay(ObjectToSaveDay day){
        ShortReport newShortReport = shortReportCreator.createNewShortReport(day);
        Day newDay = dayConverter.mappingObjectToSaveDayToDay(day);
        newDay.setShortReport(newShortReport);
        dayRepoService.addDay(newDay);
        return "Dzień z aktualną datą został dodany do bazy danych";
    }

    public String update(ObjectToSaveDay day) {
        ShortReport updatedShortReport = shortReportCreator.createToUpdateRecordByDay(day);
        dayRepoService.updateDay(dayCreator.createByDayApiAndShortDay(day, updatedShortReport));
        return "Wskazany dzień został aktualizowany wraz ze skrótem";
    }

    public String deleteDay(Long id) {
        dayRepoService.deleteDayById(id);
        return "Dzień o podanym id został usunięty wraz ze skrótem dnia";
    }
}
