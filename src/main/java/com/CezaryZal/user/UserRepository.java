package com.CezaryZal.user;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public UserRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<User> getUsers (){
        Session currentSession = sessionFactory.getCurrentSession();
        Query<User> query = currentSession.createQuery("from User order by nick", User.class);
        List<User> users = query.getResultList();

        return users;
    }

    public User getUser(int id){
        Session currentSession = sessionFactory.getCurrentSession();
        User user = currentSession.get(User.class, id);

        return user;
    }

}
