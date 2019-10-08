package com.CezaryZal.day;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Transactional
@Service
public class DayService {

    private DayRepository dayRepository;

    @Autowired
    public DayService(DayRepository dayRepository) {
        this.dayRepository = dayRepository;
    }

    public List<Day> getDays(){
        return dayRepository.getDays();
    }

    public Day getDay(int id){
        return dayRepository.getDay(id);
    }

    public Day getDayByDateAndUser (int userId, String inputDate){
        LocalDate tmpDate = LocalDate.parse(inputDate);

        return dayRepository.getDayByDateAndUser(userId, tmpDate);
    }
}
