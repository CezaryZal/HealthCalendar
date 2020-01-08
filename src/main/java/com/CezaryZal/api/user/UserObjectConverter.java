package com.CezaryZal.api.user;

import org.springframework.stereotype.Service;

@Service
public class UserObjectConverter {

    public UserDTO convertToUserDTO(User user){
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
}
