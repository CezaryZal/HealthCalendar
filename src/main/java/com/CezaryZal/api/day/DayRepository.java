package com.CezaryZal.api.day;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

@Transactional
@Repository
public class DayRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Day findById(Long id) {
        return entityManager.find(Day.class, id);
    }

    public int findDayIdByDateAndUserId(LocalDate localDate, Long userId){
        Query query = entityManager.createQuery("SELECT id FROM Day WHERE date=:inputDate AND userId=:userId");
        query.setParameter("inputDate", localDate);
        query.setParameter("userId", userId);

        return (int) query.getSingleResult();
    }

    public Day findDayByDateAndUserId(LocalDate localDate, Long userId){
        Query query = entityManager.createQuery("FROM Day WHERE date=:inputDate AND userId=:userId");
        query.setParameter("inputDate", localDate);
        query.setParameter("userId", userId);

        return (Day) query.getSingleResult();
    }

//Join fetch w query HQL pozwala zaciągnięcie wszystkich danych przy jednym zapytaniu, ale join musi istnieć(być powiązanie)
//        Query query = entityManager.createQuery("SELECT DISTINCT d FROM Day d JOIN fetch d.listNotesDB ", Day.class);


    public List<Day> getAll() {
        Query query = entityManager.createQuery("FROM Day");

        return query.getResultList();
    }

    public void save(Day day) {
        entityManager.persist(day);
    }

    public void update(Day day) {
        entityManager.merge(day);
    }

    public boolean delete(Day day) {
        if (entityManager.contains(day)) {
            entityManager.remove(day);
            return true;
        }
        return false;
    }


}
