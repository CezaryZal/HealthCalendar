package com.CezaryZal.api.user.entity;

import lombok.*;

@ToString
@Getter
@AllArgsConstructor
public abstract class FormUser {

    private Long id;
    private String firstName;
    private String nick;
    private String email;
    private int phoneNumber;
    private int sex;
    private int age;
}
