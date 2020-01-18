package com.CezaryZal.api.shortday.manager;

import com.CezaryZal.api.day.entity.api.DayApi;
import com.CezaryZal.api.day.entity.day.DayBasic;
import com.CezaryZal.api.shortday.ShortDayRepository;
import com.CezaryZal.api.shortday.entity.ShortDay;
import com.CezaryZal.api.shortday.entity.ShortDayDto;
import com.CezaryZal.api.shortday.manager.mapper.DayApiToShortDayCreator;
import com.CezaryZal.api.shortday.manager.mapper.DayBasicToShortDayCreator;
import com.CezaryZal.api.shortday.manager.mapper.ListShortDayToListDtoConverter;
import com.CezaryZal.api.shortday.manager.mapper.ShortDayToDtoConverter;
import com.CezaryZal.api.shortday.manager.repo.ShortDayRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ShortDayService extends ShortDayRepoService {

    private final ShortDayToDtoConverter shortDayToDtoConverter;
    private final ListShortDayToListDtoConverter listShortDayToListDtoConverter;
    private final DayApiToShortDayCreator dayApiToShortDayCreator;
    private final DayBasicToShortDayCreator dayBasicToShortDayCreator;

    @Autowired
    public ShortDayService(ShortDayRepository shortDayRepository,
                           ShortDayToDtoConverter shortDayToDtoConverter,
                           ListShortDayToListDtoConverter listShortDayToListDtoConverter,
                           DayApiToShortDayCreator dayApiToShortDayCreator,
                           DayBasicToShortDayCreator dayBasicToShortDayCreator) {
        super(shortDayRepository);
        this.shortDayToDtoConverter = shortDayToDtoConverter;
        this.listShortDayToListDtoConverter = listShortDayToListDtoConverter;
        this.dayApiToShortDayCreator = dayApiToShortDayCreator;
        this.dayBasicToShortDayCreator = dayBasicToShortDayCreator;
    }

    public ShortDayDto getShortDayDtoById(Long id) {
        return shortDayToDtoConverter.mappingEntity(getShortDayById(id));
    }

    public List<ShortDayDto> getShortDaysByDateAndUserId(String inputDate, Long userId) {
        LocalDate localDateMin = LocalDate.parse(inputDate).minusDays(30);
        LocalDate localDateMax = LocalDate.parse(inputDate).plusDays(30);
        List<ShortDay> shortDaysByDateAndUserId =
                getShortsDayByMaxMinDateAndUserId(localDateMin, localDateMax, userId);
        return listShortDayToListDtoConverter.mappingList(shortDaysByDateAndUserId);
    }

    public List<ShortDayDto> getShorts() {
        return listShortDayToListDtoConverter.mappingList(getAll());
    }

    public String addShortByDayApi(DayApi day) {
        addShortDay(dayApiToShortDayCreator.create(day));
        return "Przesłany skrót dnia został zapisany w bazie danych";
    }

    public ShortDay addShortByDayBasic(DayBasic day) {
        return addShortDay(dayBasicToShortDayCreator.create(day));
    }

    public String updateShort(ShortDay shortDay) {
        updateShortDay(shortDay);
        return "Przesłany skrót dnia została uaktualniona";
    }

    public String deleteShortById(Long id) {
        deleteShortDayById(id);
        return "Skrót dnia o przesłanym id został usuniety";
    }
}
