package com.CezaryZal.api.shortcut;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

@Transactional
@Repository
public class ShortDayRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public ShortDay findById (Long id){
        return entityManager.find(ShortDay.class, id);
    }

    public List<ShortDay> findByDateAndUserId(LocalDate localDateMin, LocalDate localDateMax, Long userId){
        Query query = entityManager.createQuery(
                "FROM ShortDay WHERE date>=:inputDateMin AND date<=:inputDateMax AND userId=:userId");
        query.setParameter("inputDateMin", localDateMin);
        query.setParameter("inputDateMax", localDateMax);
        query.setParameter("userId", userId);

        return query.getResultList();
    }

    public List<ShortDay> getAll(){
        Query query = entityManager.createQuery("FROM ShortDay");

        return query.getResultList();
    }

    public void save (ShortDay shortDay){
        entityManager.persist(shortDay);
    }

    public void update(ShortDay shortDay){
        entityManager.merge(shortDay);
    }

    public boolean delete (ShortDay shortDay){
        if(entityManager.contains(shortDay)){
            entityManager.remove(shortDay);
            return true;
        }
        return false;
    }
}