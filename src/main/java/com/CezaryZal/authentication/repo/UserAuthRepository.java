package com.CezaryZal.authentication.repo;

import com.CezaryZal.authentication.model.entity.UserAuthentication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface UserAuthRepository extends JpaRepository<UserAuthentication, Long> {

    @Query(value = "select users_auth.id from users_auth, user where users_auth.id = user.users_auth_id AND " +
            "user.id=:inputUserId ", nativeQuery = true)
    Optional<Long> getUserAuthIdByUserId(@Param("inputUserId") Long userId);

}
