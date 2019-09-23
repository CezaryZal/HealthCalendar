package com.CezaryZal.bodySize;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BodySizeRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public BodySizeRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public BodySize getBodySize (int id){
        Session currentSession = sessionFactory.getCurrentSession();
        BodySize bodySize = currentSession.get(BodySize.class, id);

        return bodySize;
    }
}
