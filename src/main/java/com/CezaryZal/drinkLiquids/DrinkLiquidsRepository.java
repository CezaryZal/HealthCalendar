package com.CezaryZal.drinkLiquids;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DrinkLiquidsRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public DrinkLiquidsRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public DrinkLiquids getDrinkLiquids (int id){
        Session currentSession = sessionFactory.getCurrentSession();
        DrinkLiquids drinkLiquids = currentSession.get(DrinkLiquids.class, id);

        return drinkLiquids;
    }
}
