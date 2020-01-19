package com.CezaryZal.authentication;

import com.CezaryZal.authentication.entity.UserAuthentication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserAuthRepository extends JpaRepository<UserAuthentication, Long> {

    Optional<UserAuthentication> findByLoginName(String loginName);

    @Query(value = "select id from users_auth where login_name =:loginName", nativeQuery = true)
    Optional<Long> getUserIdByLoginName(@Param("loginName") String loginName);
}
