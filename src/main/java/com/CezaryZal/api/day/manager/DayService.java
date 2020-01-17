package com.CezaryZal.api.day.manager;

import com.CezaryZal.api.day.DayRepository;
import com.CezaryZal.api.day.entity.day.Day;
import com.CezaryZal.api.day.entity.day.DayBasic;
import com.CezaryZal.api.day.entity.day.DayWithConnectedEntities;
import com.CezaryZal.api.day.manager.mapper.DayToDayBasicConverter;
import com.CezaryZal.api.day.manager.mapper.DayToDayWithEntitiesConverter;
import com.CezaryZal.api.day.manager.repo.DayRepoService;
import com.CezaryZal.api.shortday.ShortDay;
import com.CezaryZal.api.meal.entity.DailyDiet;
import com.CezaryZal.api.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DayService extends DayRepoService {

    private final DayToDayBasicConverter dayToDayBasicConverter;
    private final DayToDayWithEntitiesConverter dayToDayWithEntitiesConverter;

    @Autowired
    public DayService(DayRepository dayRepository, DayToDayBasicConverter dayToDayBasicConverter,
                      DayToDayWithEntitiesConverter dayToDayWithEntitiesConverter) {
        super(dayRepository);
        this.dayToDayBasicConverter = dayToDayBasicConverter;
        this.dayToDayWithEntitiesConverter = dayToDayWithEntitiesConverter;
    }

    public DayBasic getDayBasicById(Long id) {
        return dayToDayBasicConverter.mappingEntity(getDayById(id));
    }

    public DayWithConnectedEntities getDayWithEntitiesById(Long id) {
        return dayToDayWithEntitiesConverter.mappingEntity(getDayById(id));
    }

    public DayBasic getDayBasicByDateAndUserId(String inputDate, Long userId) {
        return dayToDayBasicConverter.mappingEntity(getDayByDateAndUserId(LocalDate.parse(inputDate), userId));
    }

    public DayWithConnectedEntities getDayWithEntitiesByDateAndUserId(String inputDate, Long userId) {
        return dayToDayWithEntitiesConverter.mappingEntity(getDayByDateAndUserId(LocalDate.parse(inputDate), userId));
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

    public String addNewDay(Day day){
        addDay(day);

        return "Dzień z aktualną datą został dodany do bazy danych";
    }

    public String update(Day day) {
        updateDay(day);

        return "Wskazany dzień został aktualizowany wraz ze skrótem";
    }

    public String deleteDay(Long id) {

        deleteDayById(id);

        return "Dzień o podanym id został usunięty wraz ze skrótem dnia";
    }


}
