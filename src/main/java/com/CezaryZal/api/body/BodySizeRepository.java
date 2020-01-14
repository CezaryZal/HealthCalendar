package com.CezaryZal.api.body;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BodySizeRepository extends CrudRepository<BodySize, Long> {


    @org.springframework.data.jpa.repository.Query(value = "select id from day where date =:inputDate and user_id =:userId", nativeQuery = true)
    Optional<Long> getDayIdByDateAndUserId(@Param("inputDate") LocalDate localDate, @Param("userId") Long userId);


    @org.springframework.data.jpa.repository.Query(value = "select date from body_size where user_id =:userId order by date desc LIMIT 1", nativeQuery = true)
    Optional<Date> findDateLastMeasureByUserId(@Param("userId") Long userId);

//    public LocalDate findDateLastMeasureByUserId (Long userId){
//        Query query = entityManager.createQuery(
//                "SELECT dateMeasurement FROM BodySize WHERE userId=:userId ORDER BY date DESC");
//        query.setParameter("userId", userId);
//        query.setMaxResults(1);
//
//        return (LocalDate) query.getSingleResult();
//    }

    @org.springframework.data.jpa.repository.Query(value = "select date from body_size where user_id =:userId", nativeQuery = true)
    List<Date> findByUserIdAllDate(@Param("userId") Long userId);

//    public List<LocalDate> findByUserIdAllDate(Long userId){
//        Query query = entityManager.createQuery("SELECT dateMeasurement FROM BodySize WHERE userId=:userId");
//        query.setParameter("userId", userId);
//
//        return query.getResultList();
//    }

    Optional<BodySize> findByDateMeasurementAndUserId(LocalDate localDate, Long userId);

}
