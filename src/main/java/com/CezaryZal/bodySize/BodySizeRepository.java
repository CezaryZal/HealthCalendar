package com.CezaryZal.bodySize;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.time.LocalDate;

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

    public BodySize getBodySizeByDateAndUserId (int userId, LocalDate tmpDate){

        System.out.println("userId: " + userId + " localDate: " + tmpDate);

        Session currentSession = sessionFactory.getCurrentSession();
//        Query<BodySize> query = currentSession.createQuery("FROM BodySize WHERE date=:inputDate AND user_Id=:nrId");
//        query.setParameter("nrId", userId);
//        query.setParameter("inputDate", tmpDate);

        //również ucieka 1 dzień.
        TypedQuery<BodySize> query = currentSession.createQuery("SELECT a FROM BodySize a WHERE a.date=:id", BodySize.class);
        query.setParameter("id", tmpDate);

        BodySize bodySize = query.getSingleResult();

        return bodySize;
    }

    public void saveBodySize (BodySize bodySize){
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(bodySize);
    }


}
