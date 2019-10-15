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

    public List<UserAllInf> getAllUsers (){
        Query query = entityManager.createQuery("SELECT u FROM UserAllInf u");

        return query.getResultList();
    }

    public void save (UserAllInf userAllInf){
        entityManager.persist(userAllInf);
    }

    public void update(UserAllInf userAllInf){
        entityManager.merge(userAllInf);
    }

    public boolean delete (UserAllInf userAllInf){
        if(entityManager.contains(userAllInf)){
            entityManager.remove(userAllInf);
            return true;
        }
        return false;
    }


}
