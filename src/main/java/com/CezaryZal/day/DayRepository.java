package com.CezaryZal.day;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
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

    public Day getDayByDateAndUser (int userId, LocalDate tmpDate){

        System.out.println("userId: " + userId + " localDate: " + tmpDate);

        LocalDate currentDate = LocalDate.of(2018, 5, 24);

        Session currentSession = sessionFactory.getCurrentSession();
        Query<Day> query = currentSession.createQuery("FROM Day WHERE dateRecord=:inputDate AND user_id=:nrId");
        query.setParameter("nrId", userId);
        query.setParameter("inputDate", tmpDate);

        Day tmpDay = query.getSingleResult();

        System.out.println(tmpDay);

        return tmpDay;
    }
}
