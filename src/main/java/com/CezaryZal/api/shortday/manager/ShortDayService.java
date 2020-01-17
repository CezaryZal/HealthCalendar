package com.CezaryZal.api.shortday.manager;

import com.CezaryZal.api.shortday.ShortDayRepository;
import com.CezaryZal.api.shortday.entity.ShortDay;
import com.CezaryZal.api.shortday.entity.ShortDayDto;
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

    @Autowired
    public ShortDayService(ShortDayRepository shortDayRepository, ShortDayToDtoConverter shortDayToDtoConverter,
                           ListShortDayToListDtoConverter listShortDayToListDtoConverter) {
        super(shortDayRepository);
        this.shortDayToDtoConverter = shortDayToDtoConverter;
        this.listShortDayToListDtoConverter = listShortDayToListDtoConverter;
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

    public String addShort(ShortDay shortDay) {
        addShortDay(shortDay);
        return "Przesłana notatka została uaktualniona";
    }

    public String updateShort(ShortDay shortDay) {
        updateShortDay(shortDay);
        return "Przesłana notatka została zapisana w bazie danych";
    }

    public String deleteShortById(Long id) {
        deleteShortDayById(id);
        return "Notatka o przesłanym id została usunieta";
    }
}
