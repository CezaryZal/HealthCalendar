package com.CezaryZal.user;

import com.CezaryZal.bodySize.BodySize;
import com.CezaryZal.dailyLimits.DailyLimits;
import com.CezaryZal.day.Day;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "nick")
    private String nick;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private int poneNumber;

    @Column(name = "login_name")
    private String loginName;

    @Column(name = "password")
    private String password;

    @Column(name = "sex")
    private int sex;

    //don't save param to table
    @Transient
    private int age;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "daily_limits_id")
    private DailyLimits dailyLimits;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
//    @JsonIgnore
    private List<BodySize> listBodySize;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Day> listDays;

    public User() {
    }

    @PostLoad
    public void calculateAge(){
        age = (int) ChronoUnit.YEARS.between(birthDate, LocalDate.now());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPoneNumber() {
        return poneNumber;
    }

    public void setPoneNumber(int poneNumber) {
        this.poneNumber = poneNumber;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public DailyLimits getDailyLimits() {
        return dailyLimits;
    }

    public void setDailyLimits(DailyLimits dailyLimits) {
        this.dailyLimits = dailyLimits;
    }

    public List<BodySize> getListBodySize() {
        return listBodySize;
    }

    public void setListBodySize(List<BodySize> listBodySize) {
        this.listBodySize = listBodySize;
    }

    public List<Day> getListDays() {
        return listDays;
    }

    public void setListDays(List<Day> listDays) {
        this.listDays = listDays;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", nick='" + nick + '\'' +
                ", email='" + email + '\'' +
                ", poneNumber=" + poneNumber +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", birthDate=" + birthDate +
                ", dailyLimits=" + dailyLimits +
                ", listBodySize=" + listBodySize +
                ", listDays=" + listDays +
                '}';
    }
}
