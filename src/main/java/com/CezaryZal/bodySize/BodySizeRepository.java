package com.CezaryZal.bodySize;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BodySizeRepository {


    @Autowired
    private SessionFactory sessionFactory;

}
