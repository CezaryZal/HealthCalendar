package com.CezaryZal.meal;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;


@Repository
@Transactional
public class MealRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Meal findById(int id){
        return entityManager.find(Meal.class, id);
    }

    public List<Meal> findByDateAndDayId(LocalDate currentDateMin, int dayId){

        Query query = entityManager.createQuery(
                "SELECT m FROM Meal m WHERE dayId=:dayId AND date_time<=:max AND date_time>=:min");
        query.setParameter("dayId", dayId);
        query.setParameter("max", currentDateMin.plusDays(1));
        query.setParameter("min", currentDateMin);

        return query.getResultList();
    }

    public List<Meal> getAll (){
        Query query = entityManager.createQuery("SELECT m FROM Meal m");

        return query.getResultList();
    }

    public void save (Meal meal){
        entityManager.persist(meal);
    }

    public void update(Meal meal){
        entityManager.merge(meal);
    }

    public boolean detele (Meal meal){
        if(entityManager.contains(meal)){
            entityManager.remove(meal);
            return true;
        }
        return false;
    }

}
