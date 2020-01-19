package com.CezaryZal.api.day.manager;

import com.CezaryZal.api.day.DayRepository;
import com.CezaryZal.api.day.entity.api.DayApi;
import com.CezaryZal.api.day.entity.day.Day;
import com.CezaryZal.api.day.entity.day.DayBasic;
import com.CezaryZal.api.day.entity.day.DayWithConnectedEntities;
import com.CezaryZal.api.day.manager.creator.DayCreator;
import com.CezaryZal.api.day.manager.mapper.*;
import com.CezaryZal.api.day.manager.repo.DayRepoService;
import com.CezaryZal.api.shortday.manager.creator.ShortDayCreator;
import com.CezaryZal.api.shortday.entity.ShortDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DayService extends DayRepoService {

    private final DayToDayBasicConverter dayToDayBasicConverter;
    private final DayToDayWithEntitiesConverter dayToDayWithEntitiesConverter;
    private final DayBasicToDayConverter dayBasicToDayConverter;
    private final DayBasicToShortDayConverter dayBasicToShortDayConverter;
    private final ShortDayCreator shortDayCreator;
    private final DayCreator dayCreator;

    @Autowired
    public DayService(DayRepository dayRepository,
                      DayToDayBasicConverter dayToDayBasicConverter,
                      DayToDayWithEntitiesConverter dayToDayWithEntitiesConverter,
                      DayBasicToDayConverter dayBasicToDayConverter,
                      DayBasicToShortDayConverter dayBasicToShortDayConverter,
                      ShortDayCreator shortDayCreator,
                      DayCreator dayCreator) {
        super(dayRepository);
        this.dayToDayBasicConverter = dayToDayBasicConverter;
        this.dayToDayWithEntitiesConverter = dayToDayWithEntitiesConverter;
        this.dayBasicToDayConverter = dayBasicToDayConverter;
        this.dayBasicToShortDayConverter = dayBasicToShortDayConverter;
        this.shortDayCreator = shortDayCreator;
        this.dayCreator = dayCreator;
    }

    public DayBasic getDayBasicById(Long id) {
        return dayToDayBasicConverter.mappingEntity(getDayById(id));
    }

    public DayWithConnectedEntities getDayWithEntitiesById(Long id) {
        return dayToDayWithEntitiesConverter.mappingEntity(getDayById(id));
    }

    public DayBasic getDayBasicByDateAndUserId(String inputDate, Long userId) {
        return dayToDayBasicConverter.mappingEntity(getDayByDateAndUserId(inputDate, userId));
    }

    public DayWithConnectedEntities getDayWithEntitiesByDateAndUserId(String inputDate, Long userId) {
        return dayToDayWithEntitiesConverter.mappingEntity(getDayByDateAndUserId(inputDate, userId));
    }

    public List<DayBasic> getDaysBasic() {
        return getAll().stream()
                .map(dayToDayBasicConverter::mappingEntity)
                .collect(Collectors.toList());
    }

    public List<DayWithConnectedEntities> getDaysWithEntities(){
        return getAll().stream()
                .map(dayToDayWithEntitiesConverter::mappingEntity)
                .collect(Collectors.toList());
    }

    public String addNewDay(DayBasic day){
        ShortDay newShortDay = dayBasicToShortDayConverter.mappingEntity(day);
        Day newDay = dayBasicToDayConverter.mappingEntity(day);
        newDay.setShortDay(newShortDay);
        addDay(newDay);

        return "Dzień z aktualną datą został dodany do bazy danych";
    }

    public String update(DayApi dayApi) {
        ShortDay updatedShortDay = shortDayCreator.createByDay(dayApi);
        updateDay(dayCreator.createByDayApiAndShortDay(dayApi, updatedShortDay));

        return "Wskazany dzień został aktualizowany wraz ze skrótem";
    }

    public String deleteDay(Long id) {
//        Day day = getDayById(id);
//        shortDayS.deleteShortDayById(day.getShortDay().getId());
        deleteDayById(id);

        return "Dzień o podanym id został usunięty wraz ze skrótem dnia";
    }


}
