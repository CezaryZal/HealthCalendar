package com.CezaryZal.training;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;


@Repository
@Transactional
public class TrainingRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public TrainingDB findById(int id){
        return entityManager.find(TrainingDB.class, id);
    }

    public List<TrainingDB> findByDateAndDayId(LocalDate currentDateMin, int dayId){

        Query query = entityManager.createQuery(
                "SELECT t FROM TrainingDB t WHERE dayId=:dayId AND date_time<=:max AND date_time>=:min");
        query.setParameter("dayId", dayId);
        query.setParameter("max", currentDateMin.plusDays(1));
        query.setParameter("min", currentDateMin);

        return query.getResultList();
    }


    public List<TrainingDB> getAll (){
        Query query = entityManager.createQuery("SELECT t FROM TrainingDB t");

        return query.getResultList();
    }

    public void save (TrainingDB trainingDB){
        entityManager.persist(trainingDB);
    }

    public void update(TrainingDB trainingDB){
        entityManager.merge(trainingDB);
    }

    public boolean delete (TrainingDB trainingDB){
        if(entityManager.contains(trainingDB)){
            entityManager.remove(trainingDB);
            return true;
        }
        return false;
    }
}