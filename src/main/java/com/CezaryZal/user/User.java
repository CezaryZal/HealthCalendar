package com.CezaryZal.user;


public class User {

    private int id;
    private int userAllInfId;
    private String firstName;
    private String nick;
    private String email;
    private int poneNumber;
    private String loginName;
    private String password;
    private int sex;
    private int drinkDemand;
    private int kcalDemand;

    public User() {
    }

    public User(int id, int userAllInfId, String firstName, String nick, String email, int poneNumber,
                String loginName, String password, int sex, int drinkDemand, int kcalDemand) {
        this.id = id;
        this.userAllInfId = userAllInfId;
        this.firstName = firstName;
        this.nick = nick;
        this.email = email;
        this.poneNumber = poneNumber;
        this.loginName = loginName;
        this.password = password;
        this.sex = sex;
        this.drinkDemand = drinkDemand;
        this.kcalDemand = kcalDemand;
    }

    public int getId() {
        return id;
    }

    public int getUserAllInfId() {
        return userAllInfId;
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

    public int getDrinkDemand() {
        return drinkDemand;
    }

    public int getKcalDemand() {
        return kcalDemand;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userAllInfId=" + userAllInfId +
                ", firstName='" + firstName + '\'' +
                ", nick='" + nick + '\'' +
                ", email='" + email + '\'' +
                ", poneNumber=" + poneNumber +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", drinkDemand=" + drinkDemand +
                ", kcalDemand=" + kcalDemand +
                '}';
    }
}
