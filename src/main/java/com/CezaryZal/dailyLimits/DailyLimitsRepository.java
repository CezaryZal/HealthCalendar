package com.CezaryZal.dailyLimits;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Transactional
@Repository
public class DailyLimitsRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public DailyLimits findById (Long id){
        return entityManager.find(DailyLimits.class, id);
    }

    public DailyLimits findByUserId (Long id){
        Query query = entityManager.createQuery("FROM DailyLimits WHERE userId=:userId");
        query.setParameter("userId", id);

        return (DailyLimits) query.getSingleResult();
    }

    public List<DailyLimits> getAll(){
        Query query = entityManager.createQuery("FROM DailyLimits");

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
