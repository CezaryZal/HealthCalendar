package com.CezaryZal.note;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Transactional
@Repository
public class NoteRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Note findById(Long id){
        return entityManager.find(Note.class, id);
    }

    public List<Note> findByDayId(Long dayId){
        Query query = entityManager.createQuery("FROM Note WHERE dayId=:dayId");
        query.setParameter("dayId", dayId);

        return query.getResultList();
    }

    public List<Note> getAll (){
        Query query = entityManager.createQuery("FROM Note");

        return query.getResultList();
    }

    public void save (Note note){
        entityManager.persist(note);
    }

    public void update(Note note){
        entityManager.merge(note);
    }

    public boolean delete (Note note){
        if(entityManager.contains(note)){
            entityManager.remove(note);
            return true;
        }
        return false;
    }

}
