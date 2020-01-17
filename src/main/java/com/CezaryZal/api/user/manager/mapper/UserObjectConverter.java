package com.CezaryZal.api.user.manager.mapper;

import com.CezaryZal.api.limits.entity.DailyLimits;
import com.CezaryZal.api.user.entity.User;
import com.CezaryZal.api.user.entity.UserCreator;
import org.springframework.stereotype.Service;

@Service
public class UserObjectConverter {


    public User convertUserCreatorToUser(UserCreator userCreator) {
        User user = new User();
        user.setDailyLimits(new DailyLimits(10, 10));
        return user;
    }
}
