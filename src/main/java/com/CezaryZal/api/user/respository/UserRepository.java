package com.CezaryZal.api.user.respository;

import com.CezaryZal.api.user.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

//    Optional<User> findByLoginName(String loginName);

}
