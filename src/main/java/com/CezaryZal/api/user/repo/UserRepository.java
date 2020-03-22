package com.CezaryZal.api.user.repo;

import com.CezaryZal.api.user.limits.model.DailyLimits;
import com.CezaryZal.api.user.model.entity.User;
import com.CezaryZal.authentication.model.ObjectToAuthResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Transactional
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByLoginName(String loginName);

    @Query(value = "SELECT id FROM user WHERE login_name =:loginName", nativeQuery = true)
    Optional<Long> getUserIdByLoginName(@Param("loginName") String loginName);

    @Query(value = "SELECT nick FROM user WHERE id=:userId", nativeQuery = true)
    Optional<String> getNick(@Param("userId") Long id);

    @Query(name = "query_to_handle_login_endpoint", nativeQuery = true)
    Optional<ObjectToAuthResponse> getResultToAuthResponse(@Param("loginName") String loginName);

    @Query(name = "Result_for_daily_limits", nativeQuery = true)
    Optional<DailyLimits> getDailyLimits(@Param("inputUserId") Long userId);

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE user SET nick=:nick, email=:email, phone_number=:phoneNumber, man=:man, " +
            "birth_date=:birthDate, kcal_demand=:kcalDemandPerDay, drink_demand=:drinkDemandPerDay " +
            "WHERE id =:userId", nativeQuery = true)
    void updateUser(@Param("nick") String nick,
                    @Param("email") String email,
                    @Param("phoneNumber") String phoneNumber,
                    @Param("man") boolean man,
                    @Param("birthDate") LocalDate birthDate,
                    @Param("kcalDemandPerDay") int kcalDemandPerDay,
                    @Param("drinkDemandPerDay") int drinkDemandPerDay,
                    @Param("userId") Long userId);

}
