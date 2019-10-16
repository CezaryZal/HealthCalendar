package com.CezaryZal.dailyLimits;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class DailyLimitsRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public DailyLimits findById (int id){
        return entityManager.find(DailyLimits.class, id);
    }

    public DailyLimits findByUserId (int id){
        Query query = entityManager.createQuery("SELECT d FROM DailyLimits d WHERE userId=:userId");
        query.setParameter("userId", id);

        return (DailyLimits) query.getSingleResult();
    }

    public List<DailyLimits> getAll(){
        Query query = entityManager.createQuery("SELECT d FROM DailyLimits d");

        return query.getResultList();
    }

    public void save (DailyLimits dailyLimits){
        entityManager.persist(dailyLimits);
    }

    public void update(DailyLimits dailyLimits){
        entityManager.merge(dailyLimits);
    }

    public boolean delete (DailyLimits dailyLimits){
        if(entityManager.contains(dailyLimits)){
            entityManager.remove(dailyLimits);
            return true;
        }
        return false;
    }


}
