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

    public DayDB findById(int id) {
        return entityManager.find(DayDB.class, id);
    }

    public int findDayIdByDateAndUserId(LocalDate localDate, int userId){
        Query query = entityManager.createQuery("SELECT id FROM DayDB WHERE date=:inputDate AND userId=:userId");
        query.setParameter("inputDate", localDate);
        query.setParameter("userId", userId);

        return (int) query.getSingleResult();
    }

    public DayDB findByDateAndUserId(LocalDate localDate, int userId){
        Query query = entityManager.createQuery("SELECT d FROM DayDB d WHERE date=:inputDate AND userId=:userId");
        query.setParameter("inputDate", localDate);
        query.setParameter("userId", userId);

        return (DayDB) query.getSingleResult();
    }

    public List<DayDB> getAll() {
        Query query = entityManager.createQuery("SELECT d FROM DayDB d");

        return query.getResultList();
    }

    public void save(DayDB dayDB) {
        entityManager.persist(dayDB);
    }

    public void update(DayDB dayDB) {
        entityManager.merge(dayDB);
    }

    public boolean delete(DayDB dayDB) {
        if (entityManager.contains(dayDB)) {
            entityManager.remove(dayDB);
            return true;
        }
        return false;
    }


}
