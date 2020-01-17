package com.CezaryZal.api.day;

import com.CezaryZal.api.day.entity.day.Day;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface DayRepository extends JpaRepository<Day, Long> {

    @Query(value = "select id from day where date =:inputDate and user_id =:userId", nativeQuery = true)
    Optional<Long> getDayIdByDateAndUserId(@Param("inputDate") LocalDate localDate, @Param("userId") Long userId);

    Optional<Day> findDayByDateAndUserId(LocalDate localDate, Long userId);

//Join fetch w query HQL pozwala zaciągnięcie wszystkich danych przy jednym zapytaniu, ale join musi istnieć(być powiązanie)
//        Query query = entityManager.createQuery("SELECT DISTINCT d FROM Day d JOIN fetch d.listNotesDB ", Day.class);

}
