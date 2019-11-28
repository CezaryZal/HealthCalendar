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


    public User findById(Long id){
        return entityManager.find(User.class, id);
    }

    public List<User> getAll (){
        Query query = entityManager.createQuery("FROM User");

        return query.getResultList();
    }

    public void save (User user){
        entityManager.persist(user);
    }

    public void update(User user){
        entityManager.merge(user);
    }

    public boolean delete (User user){
        if(entityManager.contains(user)){
            entityManager.remove(user);
            return true;
        }
        return false;
    }


}
