package com.CezaryZal.api.shortday.manager;

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
public class ShortDayService {

    private final ShortDayRepoService shortDayRepoService;
    private final ShortDayToDtoConverter shortDayToDtoConverter;
    private final ListShortDayToListDtoConverter listShortDayToListDtoConverter;

    @Autowired
    public ShortDayService(ShortDayRepoService shortDayRepoService,
                           ShortDayToDtoConverter shortDayToDtoConverter,
                           ListShortDayToListDtoConverter listShortDayToListDtoConverter) {
        this.shortDayRepoService = shortDayRepoService;
        this.shortDayToDtoConverter = shortDayToDtoConverter;
        this.listShortDayToListDtoConverter = listShortDayToListDtoConverter;
    }

    public ShortDayDto getShortDayDtoById(Long id) {
        return shortDayToDtoConverter.mappingEntity(shortDayRepoService.getShortDayById(id));
    }

    public ShortDayDto getShortDayDtoByDateAndUserId(LocalDate localDate, Long userId) {
        return shortDayToDtoConverter.mappingEntity(shortDayRepoService.getShortDayByDateAndUserId(localDate, userId));
    }

    public List<ShortDayDto> getShortDaysByInputDateAndUserId(String inputDate, Long userId) {
        return getShortDaysByDateAndUserId(LocalDate.parse(inputDate), userId);
    }

    public List<ShortDayDto> getShortDaysByDateAndUserId(LocalDate inputLocalDate, Long userId) {
        LocalDate localDateMin = inputLocalDate.minusDays(30);
        LocalDate localDateMax = inputLocalDate.plusDays(30);
        List<ShortDay> shortDaysByDateAndUserId =
                shortDayRepoService.getShortsDayByMaxMinDateAndUserId(localDateMin, localDateMax, userId);
        return listShortDayToListDtoConverter.mappingList(shortDaysByDateAndUserId);
    }

    public List<ShortDayDto> getShorts() {
        return listShortDayToListDtoConverter.mappingList(shortDayRepoService.getAll());
    }

}
