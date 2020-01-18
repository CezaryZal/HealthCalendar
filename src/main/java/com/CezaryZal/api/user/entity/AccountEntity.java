package com.CezaryZal.api.user.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@Getter
public class AccountEntity extends FormUser {


    private String password;
    private String permissions;
    private LocalDate birthDate;
    private int kcalDemandPerDay;
    private int drinkDemandPerDay;

    public AccountEntity(
            Long id,
            String loginName,
            String nick,
            String email,
            int phoneNumber,
            int sex,
            String password,
            String permissions,
            LocalDate birthDate,
            int kcalDemandPerDay,
            int drinkDemandPerDay) {
        super(id, loginName, nick, email, phoneNumber, sex);
        this.password = password;
        this.permissions = permissions;
        this.birthDate = birthDate;
        this.kcalDemandPerDay = kcalDemandPerDay;
        this.drinkDemandPerDay = drinkDemandPerDay;
    }
}
