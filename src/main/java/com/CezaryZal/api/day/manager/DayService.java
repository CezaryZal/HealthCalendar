package com.CezaryZal.api.day.manager;

import com.CezaryZal.api.day.model.ObjectToSaveDay;
import com.CezaryZal.api.day.model.DayDto;
import com.CezaryZal.api.day.model.entity.Day;
import com.CezaryZal.api.day.repo.DayRepository;
import com.CezaryZal.api.report.shortened.manager.ShortReportService;
import com.CezaryZal.api.report.shortened.model.entity.ShortReport;
import com.CezaryZal.exceptions.not.found.DayNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DayService {

    private final DayRepository dayRepository;
    private final DayConverter dayConverter;
    private final ShortReportService shortReportService;
    private final DayCreator dayCreator;
    private final DayDtoCreator dayDtoCreator;

    @Autowired
    public DayService(DayRepository dayRepository,
                      DayConverter dayConverter,
                      ShortReportService shortReportService,
                      DayCreator dayCreator,
                      DayDtoCreator dayDtoCreator) {
        this.dayRepository = dayRepository;
        this.dayConverter = dayConverter;
        this.shortReportService = shortReportService;
        this.dayCreator = dayCreator;
        this.dayDtoCreator = dayDtoCreator;
    }

    public DayDto getDayDtoById(Long id) {
        Day day = dayRepository.findById(id)
                .orElseThrow(() -> new DayNotFoundException("Day not found by id"));
        return dayDtoCreator.createDayDtoByDayAndDayId(day);
    }

    public DayDto getDayDtoByDateAndUserId(String inputDate, Long userId) {
        return dayConverter.mappingDayToDto(getDayByDateAndUserId(inputDate, userId));
    }

    public List<DayDto> getDaysDto(){
        return dayRepository.findAll()
                .stream()
                .map(dayConverter::mappingDayToDto)
                .collect(Collectors.toList());
    }

    public String addNewDay(ObjectToSaveDay day){
        ShortReport newShortReport = shortReportService.createShortReport(day, null, true);
        dayRepository.save(dayCreator.createDayByDayApi(day, newShortReport));
        return "Dzień z aktualną datą został dodany do bazy danych";
    }

    public String update(ObjectToSaveDay day, Long dayId) {
        ShortReport updatedShortReport = shortReportService.createShortReport(day, dayId, false);
        dayRepository.save(dayCreator.createDayToUpdateByDayApiAndShortDay(day, updatedShortReport, dayId));
        return "Wskazany dzień został aktualizowany wraz ze skrótem";
    }

    public String deleteDay(Long id) {
        dayRepository.deleteById(id);
        return "Dzień o podanym id został usunięty wraz ze skrótem dnia";
    }

    public Long getDayIdByDateAndUserId(String inputDate, Long userId) {
        return dayRepository.getDayIdByDateAndUserId(LocalDate.parse(inputDate), userId)
                .orElseThrow(() -> new DayNotFoundException("Id day not found by date and user id"));
    }

    public Day getDayByDateAndUserId(String inputDate, Long userId) {
        return dayRepository.findDayByDateAndUserId(LocalDate.parse(inputDate), userId)
                .orElseThrow(() -> new DayNotFoundException("Day not found by date and user id"));
    }

}
