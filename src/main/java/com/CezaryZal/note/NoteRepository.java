package com.CezaryZal.note;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class NoteRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public NoteDB findById(int id){
        return entityManager.find(NoteDB.class, id);
    }

    public List<NoteDB> findByDayId(int dayId){
        Query query = entityManager.createQuery("FROM NoteDB WHERE dayId=:dayId");
        query.setParameter("dayId", dayId);

        return query.getResultList();
    }

    public List<NoteDB> getAll (){
        Query query = entityManager.createQuery("FROM NoteDB");

        return query.getResultList();
    }

    public void save (NoteDB noteDB){
        entityManager.persist(noteDB);
    }

    public void update(NoteDB noteDB){
        entityManager.merge(noteDB);
    }

    public boolean delete (NoteDB noteDB){
        if(entityManager.contains(noteDB)){
            entityManager.remove(noteDB);
            return true;
        }
        return false;
    }

}
