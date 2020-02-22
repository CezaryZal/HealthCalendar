package com.CezaryZal.api.user.repo;

import com.CezaryZal.api.user.limits.model.DailyLimitsTmp;
import com.CezaryZal.api.user.model.entity.User;
import com.CezaryZal.authentication.model.ObjectToAuthResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

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
    Optional<DailyLimitsTmp> getDailyLimits(@Param("inputUserId") Long userId);

}
