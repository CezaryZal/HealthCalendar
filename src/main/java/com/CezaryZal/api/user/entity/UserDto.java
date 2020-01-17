package com.CezaryZal.api.user.entity;

public class UserDto extends FormUser{

    public UserDto(
            Long id,
            String firstName,
            String nick,
            String email,
            int phoneNumber,
            int sex,
            int age) {
        super(id, firstName, nick, email, phoneNumber, sex, age);
    }
}
