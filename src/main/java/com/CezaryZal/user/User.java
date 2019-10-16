package com.CezaryZal.user;


public class User {

    private int userAllInfId;
    private String firstName;
    private String nick;
    private String email;
    private int poneNumber;
    private String loginName;
    private String password;
    private int sex;

    public User() {
    }

    public User(int userAllInfId, String firstName, String nick, String email, int poneNumber, String loginName,
                String password, int sex) {
        this.userAllInfId = userAllInfId;
        this.firstName = firstName;
        this.nick = nick;
        this.email = email;
        this.poneNumber = poneNumber;
        this.loginName = loginName;
        this.password = password;
        this.sex = sex;
    }

    public int getUserAllInfId() {
        return userAllInfId;
    }

    public void setUserAllInfId(int userAllInfId) {
        this.userAllInfId = userAllInfId;
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

    @Override
    public String toString() {
        return "User{" +
                "userAllInfId=" + userAllInfId +
                ", firstName='" + firstName + '\'' +
                ", nick='" + nick + '\'' +
                ", email='" + email + '\'' +
                ", poneNumber=" + poneNumber +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                '}';
    }
}
