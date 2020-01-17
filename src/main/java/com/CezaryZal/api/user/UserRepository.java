package com.CezaryZal.api.user;

import com.CezaryZal.api.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByLoginName(String loginName);

    @Query(value = "select id from user where login_name =:loginName", nativeQuery = true)
    Optional<Long> getUserIdByLoginName(@Param("loginName") String loginName);

}
