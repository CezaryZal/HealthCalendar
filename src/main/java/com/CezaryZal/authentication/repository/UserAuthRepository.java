package com.CezaryZal.authentication.repository;

import com.CezaryZal.authentication.entity.UserAuthentication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserAuthRepository extends JpaRepository<UserAuthentication, Long> {

    Optional<UserAuthentication> findByLoginName(String loginName);
}
