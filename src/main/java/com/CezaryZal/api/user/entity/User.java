package com.CezaryZal.api.user.entity;

import com.CezaryZal.api.body.entity.BodySize;
import com.CezaryZal.api.limits.entity.DailyLimits;
import com.CezaryZal.api.day.model.entity.Day;
import com.CezaryZal.authentication.entity.UserAuthentication;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "login_name")
    private String loginName;

    @Column(name = "nick")
    private String nick;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private int phoneNumber;

    @Column(name = "sex")
    private int sex;

    //don't save param to table
    @Transient
    private int age;

    //add active to block access sometimes

    //birthDate not be null, never
    @Column(name = "birth_date")
    private LocalDate birthDate;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "daily_limits_id")
    private DailyLimits dailyLimits;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "users_auth_id")
    private UserAuthentication userAuthentication;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
//    @JsonIgnore
    private List<BodySize> listMeasureByBodySize;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Day> listDays;

    public User(
            String loginName,
            String nick,
            String email,
            int phoneNumber,
            int sex,
            LocalDate birthDate
            ) {
        this.loginName = loginName;
        this.nick = nick;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
        this.birthDate = birthDate;
    }

    public User(
            Long id,
            String loginName,
            String nick,
            String email,
            int phoneNumber,
            int sex,
            LocalDate birthDate,
            DailyLimits dailyLimits,
            UserAuthentication userAuthentication) {
        this.id = id;
        this.loginName = loginName;
        this.nick = nick;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
        this.birthDate = birthDate;
        this.dailyLimits = dailyLimits;
        this.userAuthentication = userAuthentication;
    }

    @PostLoad
    public void calculateAge(){
        if (birthDate != null){
            age = (int) ChronoUnit.YEARS.between(birthDate, LocalDate.now());
        }
    }



}
