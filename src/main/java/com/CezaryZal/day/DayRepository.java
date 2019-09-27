package com.CezaryZal.day;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DayRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public DayRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Day> getDays(){
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Day> query = currentSession.createQuery("from Day order by date", Day.class);
        List<Day> days = query.getResultList();

        return days;
    }

    public Day getDay(int id){
        Session currentSession = sessionFactory.getCurrentSession();
        Day day = currentSession.get(Day.class, id);

        return day;
    }
}
