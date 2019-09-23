package com.CezaryZal.bodySize;

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
}
