package com.CezaryZal.user;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;


    public UserAllInf getUserAllInfById(int id){
        return entityManager.find(UserAllInf.class, id);
    }

//    public List<User> getUsers (){
//        Session currentSession = sessionFactory.getCurrentSession();
//        Query<User> query = currentSession.createQuery("from User order by nick", User.class);
//        List<User> users = query.getResultList();
//
//        return users;
//    }

    public void save (User user){
        entityManager.persist(user);
    }


}
