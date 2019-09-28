package com.CezaryZal.note;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoteRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public NoteRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Note getNote(int id){
        Session currentSession = sessionFactory.getCurrentSession();
        Note note = currentSession.get(Note.class, id);

        return note;
    }
}
