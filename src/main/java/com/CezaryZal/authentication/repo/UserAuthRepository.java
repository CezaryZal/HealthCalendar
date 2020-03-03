package com.CezaryZal.authentication.repo;

import com.CezaryZal.authentication.model.entity.UserAuthentication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserAuthRepository extends JpaRepository<UserAuthentication, Long> {

    @Query(value = "SELECT users_auth.id FROM users_auth, user WHERE users_auth.id = user.users_auth_id AND " +
            "user.id=:inputUserId ", nativeQuery = true)
    Optional<Long> getUserAuthIdByUserId(@Param("inputUserId") Long userId);

    @Query(value = "SELECT * FROM users_auth, user WHERE users_auth.id = user.users_auth_id AND " +
            "user.id=:inputUserId ", nativeQuery = true)
    Optional<UserAuthentication> getUserAuthByUserId(@Param("inputUserId") Long userId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE health_calendar.users_auth, health_calendar.user SET users_auth.password=:newPassword " +
            "WHERE users_auth.id = user.users_auth_id AND user.id=:inputUserId", nativeQuery = true)
    void updatePasswordUserByUserId(@Param("newPassword") String password, @Param("inputUserId") Long userId);

}
