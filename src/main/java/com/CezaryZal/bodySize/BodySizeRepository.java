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

    public BodySize findById (int id){
        BodySize bodySize = entityManager.find(BodySize.class, id);

        return bodySize;
    }

    public BodySize findByDateAndUserId(LocalDate localDate, int userId) {
        Query query = entityManager.createQuery("SELECT b FROM BodySize b WHERE date=:inputDate AND userId=:userId");
        query.setParameter("inputDate", localDate);
        query.setParameter("userId", userId);

        BodySize bodySize = (BodySize) query.getSingleResult();
        return bodySize;
    }

    public List<BodySize> getAll(){
        Query query = entityManager.createQuery("SELECT b FROM BodySize b");

        return query.getResultList();
    }

    public void save (BodySize bodySize){
        entityManager.persist(bodySize);
    }

    public boolean delete (BodySize bodySize) {
        if (entityManager.contains(bodySize)){
            entityManager.remove(bodySize);
            return true;
        }
        return false;
    }

}
