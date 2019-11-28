package com.CezaryZal.bodySize;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;


@Repository
@Transactional
public class BodySizeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public BodySize findById (Long id){
        return entityManager.find(BodySize.class, id);
    }

    public LocalDate findDateLastMeasureByUserId (Long userId){
        Query query = entityManager.createQuery(
                "SELECT date FROM BodySize WHERE userId=:userId ORDER BY date DESC");
        query.setParameter("userId", userId);
        query.setMaxResults(1);

        return (LocalDate) query.getSingleResult();
    }

    public List<LocalDate> findByUserIdAllDate(Long userId){
        Query query = entityManager.createQuery("SELECT date FROM BodySize WHERE userId=:userId");
        query.setParameter("userId", userId);

        return query.getResultList();
    }

    public BodySize findByDateAndUserId(LocalDate localDate, Long userId){
        Query query = entityManager.createQuery("FROM BodySize WHERE date=:inputDate AND userId=:userId");
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
