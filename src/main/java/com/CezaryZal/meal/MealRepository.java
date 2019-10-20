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

    public MealDB findById(int id){
        return entityManager.find(MealDB.class, id);
    }

    public List<MealDB> findByDayId(int dayId){
        Query query = entityManager.createQuery("SELECT m FROM MealDB m WHERE dayId=:dayId");
        query.setParameter("dayId", dayId);

        return query.getResultList();
    }

    public List<MealDB> getAll (){
        Query query = entityManager.createQuery("SELECT m FROM MealDB m");

        return query.getResultList();
    }

    public void save (MealDB mealDB){
        entityManager.persist(mealDB);
    }

    public void update(MealDB mealDB){
        entityManager.merge(mealDB);
    }

    public boolean delete (MealDB mealDB){
        if(entityManager.contains(mealDB)){
            entityManager.remove(mealDB);
            return true;
        }
        return false;
    }

}
