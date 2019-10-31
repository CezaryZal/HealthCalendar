package com.CezaryZal.training;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class TrainingRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Training findById(int id){
        return entityManager.find(Training.class, id);
    }

    public List<Training> findByDayId(int dayId){
        Query query = entityManager.createQuery("SELECT t FROM Training t WHERE dayId=:dayId");
        query.setParameter("dayId", dayId);

        return query.getResultList();
    }

    public List<Training> getAll (){
        Query query = entityManager.createQuery("SELECT t FROM Training t");

        return query.getResultList();
    }

    public void save (Training training){
        entityManager.persist(training);
    }

    public void update(Training training){
        entityManager.merge(training);
    }

    public boolean delete (Training training){
        if(entityManager.contains(training)){
            entityManager.remove(training);
            return true;
        }
        return false;
    }
}
