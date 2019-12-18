package com.CezaryZal.bodySize;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

@Transactional
@Repository
public class BodySizeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public BodySize findById (Long id){
        return entityManager.find(BodySize.class, id);
    }

    public LocalDate findDateLastMeasureByUserId (Long userId){
        Query query = entityManager.createQuery(
                "SELECT dateMeasurement FROM BodySize WHERE userId=:userId ORDER BY date DESC");
        query.setParameter("userId", userId);
        query.setMaxResults(1);

        return (LocalDate) query.getSingleResult();
    }

    public List<LocalDate> findByUserIdAllDate(Long userId){
        Query query = entityManager.createQuery("SELECT dateMeasurement FROM BodySize WHERE userId=:userId");
        query.setParameter("userId", userId);

        return query.getResultList();
    }

    public BodySize findByDateAndUserId(LocalDate localDate, Long userId){
        Query query = entityManager.createQuery("FROM BodySize WHERE dateMeasurement=:inputDate AND userId=:userId");
        query.setParameter("inputDate", localDate);
        query.setParameter("userId", userId);

        return (BodySize) query.getSingleResult();
    }

    public List<BodySize> getAll(){
        Query query = entityManager.createQuery("FROM BodySize");

        return query.getResultList();
    }

    public void save (BodySize bodySize){
        entityManager.persist(bodySize);
    }

    public boolean delete (BodySize bodySize){
        if (entityManager.contains(bodySize)){
            entityManager.remove(bodySize);
            return true;
        }
        return false;
    }


}
