package com.CezaryZal.meal;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository
public class MealRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Meal findById(Long id){
        return entityManager.find(Meal.class, id);
    }

    public List<Meal> getListByDayId(Long dayId){
        Query query = entityManager.createQuery("FROM Meal WHERE dayId=:dayId");
        query.setParameter("dayId", dayId);

        return query.getResultList();
    }

    public List<Meal> getAll (){
        Query query = entityManager.createQuery("FROM Meal");

        return query.getResultList();
    }

    public void save (Meal meal){
        entityManager.persist(meal);
    }

    public void update(Meal meal){
        entityManager.merge(meal);
    }

    public boolean delete (Meal meal){
        if(entityManager.contains(meal)){
            entityManager.remove(meal);
            return true;
        }
        return false;
    }

}
