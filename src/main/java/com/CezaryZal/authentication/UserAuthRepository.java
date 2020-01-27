package com.CezaryZal.authentication;

import com.CezaryZal.authentication.model.entity.UserAuthentication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuthRepository extends JpaRepository<UserAuthentication, Long> {

}
