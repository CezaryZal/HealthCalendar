package com.CezaryZal.api.user.model;

import lombok.*;

@ToString
@Getter
@AllArgsConstructor
public abstract class FormUser {

    private Long id;
    private String loginName;
    private String nick;
    private String email;
    private int phoneNumber;
    private int sex;
}
