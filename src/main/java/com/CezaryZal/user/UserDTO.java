package com.CezaryZal.user;


import com.CezaryZal.dailyLimits.DailyLimits;

public class UserDTO {

    private Long id;
    private String firstName;
    private String nick;
    private String email;
    private int poneNumber;
    private String loginName;
    private String password;
    private int sex;
    private int age;
    private DailyLimits dailyLimits;

    public UserDTO(Long id, String firstName, String nick, String email, int poneNumber, String loginName,
                   String password, int sex, int age, DailyLimits dailyLimits) {
        this.id = id;
        this.firstName = firstName;
        this.nick = nick;
        this.email = email;
        this.poneNumber = poneNumber;
        this.loginName = loginName;
        this.password = password;
        this.sex = sex;
        this.age = age;
        this.dailyLimits = dailyLimits;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getNick() {
        return nick;
    }

    public String getEmail() {
        return email;
    }

    public int getPoneNumber() {
        return poneNumber;
    }

    public String getLoginName() {
        return loginName;
    }

    public String getPassword() {
        return password;
    }

    public int getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public DailyLimits getDailyLimits() {
        return dailyLimits;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", nick='" + nick + '\'' +
                ", email='" + email + '\'' +
                ", poneNumber=" + poneNumber +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", dailyLimits=" + dailyLimits +
                '}';
    }
}
