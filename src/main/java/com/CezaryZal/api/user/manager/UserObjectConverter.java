package com.CezaryZal.api.user.manager;

import com.CezaryZal.api.limits.DailyLimits;
import com.CezaryZal.api.user.entity.User;
import com.CezaryZal.api.user.entity.UserCreator;
import com.CezaryZal.api.user.entity.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class UserObjectConverter {

    protected UserDTO convertUserToUserDTO(User user) {
        return new UserDTO(user.getId(),
                user.getFirstName(),
                user.getNick(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getSex(),
                user.getAge(),
                user.getDailyLimits()
        );
    }

    protected User convertUserCreatorToUser(UserCreator userCreator) {
        User user = new User(userCreator.getLoginName(), userCreator.getEmail());
        user.setDailyLimits(new DailyLimits(10, 10));
        return user;
    }
}
