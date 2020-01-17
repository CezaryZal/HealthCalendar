package com.CezaryZal.api.shortday.manager.mapper;

import com.CezaryZal.api.shortday.entity.ShortDay;
import com.CezaryZal.api.shortday.entity.ShortDayDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListShortDayToListDtoConverter {

    private final ShortDayToDtoConverter shortDayToDtoConverter;

    @Autowired
    public ListShortDayToListDtoConverter(ShortDayToDtoConverter shortDayToDtoConverter) {
        this.shortDayToDtoConverter = shortDayToDtoConverter;
    }

    public List<ShortDayDto> mappingList(List<ShortDay> shortDaysDto){
        return shortDaysDto.stream()
                .map(shortDayToDtoConverter::mappingEntity)
                .collect(Collectors.toList());
    }
}
