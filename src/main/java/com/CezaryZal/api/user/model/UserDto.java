package com.CezaryZal.api.user.model;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class UserDto extends FormUser{

    private int age;

    public UserDto(
            Long id,
            String loginName,
            String nick,
            String email,
            int phoneNumber,
            int sex,
            int age) {
        super(id, loginName, nick, email, phoneNumber, sex);
        this.age = age;
    }
}
