package com.CezaryZal.api.user;


import com.CezaryZal.api.limits.DailyLimits;

public class UserDTO {

    private Long id;
    private String firstName;
    private String nick;
    private String email;
    private int phoneNumber;
    private int sex;
    private int age;
    private DailyLimits dailyLimits;

    public UserDTO(Long id, String firstName, String nick, String email, int phoneNumber, int sex, int age, DailyLimits dailyLimits) {
        this.id = id;
        this.firstName = firstName;
        this.nick = nick;
        this.email = email;
        this.phoneNumber = phoneNumber;
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

    public int getPhoneNumber() {
        return phoneNumber;
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
                ", poneNumber=" + phoneNumber +
                ", sex=" + sex +
                ", age=" + age +
                ", dailyLimits=" + dailyLimits +
                '}';
    }
}
