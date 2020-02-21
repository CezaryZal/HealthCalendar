package com.CezaryZal.api.user.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@Getter
@NoArgsConstructor
public class AccountEntity {

    private Long id;
    private String loginName;
    private String nick;
    private String email;
    private String phoneNumber;
    private boolean man;
    private String password;
    private String permissions;
    private LocalDate birthDate;
    private int kcalDemandPerDay;
    private int drinkDemandPerDay;

    public void setPassword(String password) {
        this.password = password;
    }
}
