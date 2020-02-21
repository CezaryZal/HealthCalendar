package com.CezaryZal.api.user.model.entity;

import com.CezaryZal.api.body.model.entity.BodySize;
import com.CezaryZal.api.limits.model.entity.DailyLimits;
import com.CezaryZal.api.day.model.entity.Day;
import com.CezaryZal.authentication.model.entity.UserAuthentication;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Entity
@Table(name = "user")
@Data
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
    private String phoneNumber;

    @Column(name = "man")
    private boolean man;

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

    @PostLoad
    public void calculateAge(){
        if (birthDate != null){
            age = (int) ChronoUnit.YEARS.between(birthDate, LocalDate.now());
        }
    }


    public static Builder builder(){
        return new Builder();
    }

    public static final class Builder{
        private Long id;
        private String loginName;
        private String nick;
        private String email;
        private String phoneNumber;
        private boolean man;
        private LocalDate birthDate;
        private DailyLimits dailyLimits;
        private UserAuthentication userAuthentication;

        public Builder id(Long id){
            this.id = id;
            return this;
        }
        public Builder loginName(String loginName){
            this.loginName = loginName;
            return this;
        }
        public Builder nick(String nick){
            this.nick = nick;
            return this;
        }
        public Builder email(String email){
            this.email = email;
            return this;
        }
        public Builder phoneNumber(String phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }
        public Builder man(boolean man){
            this.man = man;
            return this;
        }
        public Builder birthDate(LocalDate birthDate){
            this.birthDate = birthDate;
            return this;
        }
        public Builder dailyLimits(DailyLimits dailyLimits){
            this.dailyLimits = dailyLimits;
            return this;
        }
        public Builder userAuthentication(UserAuthentication userAuthentication){
            this.userAuthentication = userAuthentication;
            return this;
        }

        public User build(){
            User user = new User();
            user.id = this.id;
            user.loginName = this.loginName;
            user.nick = this.nick;
            user.email = this.email;
            user.phoneNumber = this.phoneNumber;
            user.man = this.man;
            user.birthDate = this.birthDate;
            user.dailyLimits = this.dailyLimits;
            user.userAuthentication = this.userAuthentication;
            return user;
        }
    }
}
