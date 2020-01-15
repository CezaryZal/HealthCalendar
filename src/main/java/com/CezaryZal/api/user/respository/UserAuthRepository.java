package com.CezaryZal.api.user.respository;

import com.CezaryZal.api.user.entity.UserAuthentication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserAuthRepository extends CrudRepository<UserAuthentication, Long> {


    Optional<UserAuthentication> findByLoginName(String loginName);
}
