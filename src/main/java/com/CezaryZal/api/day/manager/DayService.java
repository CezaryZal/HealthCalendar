package com.CezaryZal.api.day.manager;

import com.CezaryZal.api.day.model.ObjectToSaveDay;
import com.CezaryZal.api.day.model.DayDto;
import com.CezaryZal.api.day.model.entity.Day;
import com.CezaryZal.api.day.repo.DayRepository;
import com.CezaryZal.api.report.shortened.manager.ShortReportCreator;
import com.CezaryZal.api.report.shortened.manager.ShortReportService;
import com.CezaryZal.api.report.shortened.model.entity.ShortReport;
import com.CezaryZal.exceptions.not.found.DayNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DayService {

    private final DayRepository dayRepository;
    private final DayConverter dayConverter;
    private final ShortReportService shortReportService;
    private final ShortReportCreator shortReportCreator;
    private final DayCreator dayCreator;

    @Autowired
    public DayService(DayRepository dayRepository,
                      DayConverter dayConverter,
                      ShortReportService shortReportService,
                      ShortReportCreator shortReportCreator,
                      DayCreator dayCreator) {
        this.dayRepository = dayRepository;
        this.dayConverter = dayConverter;
        this.shortReportService = shortReportService;
        this.shortReportCreator = shortReportCreator;
        this.dayCreator = dayCreator;
    }

    public DayDto getDayDtoById(Long dayId) {
        Day foundDay = getDayByDayId(dayId);
        return dayConverter.mappingDayToDto(foundDay);
    }

    public Long getDayIdByDateAndUserId(String inputDate, Long userId) {
        return dayRepository.getDayIdByDateAndUserId(LocalDate.parse(inputDate), userId)
                .orElseThrow(() -> new DayNotFoundException("Id day not found by date and user id"));
    }

    public DayDto getDayDtoByDateAndUserId(String inputDate, Long userId) {
        return dayConverter.mappingDayToDto(getDayByDateAndUserId(inputDate, userId));
    }

    public Day getDayByDateAndUserId(String inputDate, Long userId) {
        return dayRepository.findDayByDateAndUserId(LocalDate.parse(inputDate), userId)
                .orElseThrow(() -> new DayNotFoundException("Day not found by date and user id"));
    }

    public List<DayDto> getDaysDtoByUserId(Long userId){
        List<Day> dayList = dayRepository.findDaysByUserId(userId);
        return dayList.isEmpty() ? null : dayConverter.mappingListDayToListDto(dayList);
    }

    public List<DayDto> getDaysDto(){
        List<Day> all = dayRepository.findAll();
        return dayConverter.mappingListDayToListDto(all);
    }

    public String addNewDay(ObjectToSaveDay objectToSaveDay){
        ShortReport newShortReport = shortReportCreator.createNewShortReport(objectToSaveDay);
        dayRepository.save(dayCreator.createDayByDayApi(objectToSaveDay, newShortReport));
        return "Received the day object has been saved to the database with its shortcut";
    }

    public String updateDay(ObjectToSaveDay objectToSaveDay, Long dayId) {
        shortReportService.updateShortReport(objectToSaveDay, dayId);
        dayRepository.updatePortionsAlcohol(
                objectToSaveDay.getPortionsAlcohol(),
                objectToSaveDay.getPortionsDrink(),
                objectToSaveDay.getPortionsSnack(),
                dayId);
        return "Received the day object has been updated with its shortcut";
    }

    public String deleteDay(Long id) {
        dayRepository.deleteById(id);
        return "The day with its shortcut has been removed based on Id";
    }

    private Day getDayByDayId(Long dayId){
        return dayRepository.findById(dayId)
                .orElseThrow(() -> new DayNotFoundException("Day not found by id"));
    }
}
