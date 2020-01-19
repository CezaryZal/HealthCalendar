package com.CezaryZal.authentication.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users_auth")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserAuthentication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    //unique
    @Column(name = "login_name")
    private String loginName;

    @Column(name = "password")
    private String password;

    @Column(name = "active")
    private boolean active;

    @Column(name = "roles")
    private String roles;

    @Column(name = "permissions")
    private String permissions;

    public void setId(Long id) {
        this.id = id;
    }
}
