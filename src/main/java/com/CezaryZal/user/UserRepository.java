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


    public UserDB getUserDBById(int id){
        return entityManager.find(UserDB.class, id);
    }

    public List<UserDB> getAll (){
        Query query = entityManager.createQuery("SELECT u FROM UserAllInf u");

        return query.getResultList();
    }

    public void save (UserDB userDB){
        entityManager.persist(userDB);
    }

    public void update(UserDB userDB){
        entityManager.merge(userDB);
    }

    public boolean delete (UserDB userDB){
        if(entityManager.contains(userDB)){
            entityManager.remove(userDB);
            return true;
        }
        return false;
    }


}
