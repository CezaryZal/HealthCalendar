package com.CezaryZal.day;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
public class DayRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Day findById(int id) {
        return entityManager.find(Day.class, id);
    }

    public int findDayIdByDateAndUserId(LocalDate localDate, int userId){
        Query query = entityManager.createQuery("SELECT id FROM DayDB WHERE date=:inputDate AND userId=:userId");
        query.setParameter("inputDate", localDate);
        query.setParameter("userId", userId);

        return (int) query.getSingleResult();
    }

    public Day findDayByDateAndUserId(LocalDate localDate, int userId){
        Query query = entityManager.createQuery("SELECT d FROM DayDB d WHERE date=:inputDate AND userId=:userId");
        query.setParameter("inputDate", localDate);
        query.setParameter("userId", userId);

        return (Day) query.getSingleResult();
    }

    public List<Day> getAll() {
        Query query = entityManager.createQuery("SELECT d FROM DayDB d");

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
