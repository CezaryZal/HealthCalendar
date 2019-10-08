//package com.CezaryZal.user;
//
//import com.CezaryZal.bodySize.BodySize;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Table(name = "user")
//public class User {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private int id;
//
//    @Column(name = "first_name")
//    private String firstName;
//
//    @Column(name = "nick")
//    private String nick;
//
//    @Column(name = "email")
//    private String email;
//
//    @Column(name = "phone_number")
//    private int poneNumber;
//
//    @Column(name = "login_name")
//    private String loginName;
//
//    @Column(name = "password")
//    private String password;
//
//    @Column(name = "sex")
//    private int sex;
//
//    //Default fetch is LAZY, when we want to show all data must be EAGER
//    //or cut relation between 'user' with 'bodySize'
//    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id")
//    private List<BodySize> listBodySize;
//
//
//    public User() {
//    }
//
//    public User(String firstName, String nick, String email, int poneNumber, String loginName, String password, int sex) {
//        this.firstName = firstName;
//        this.nick = nick;
//        this.email = email;
//        this.poneNumber = poneNumber;
//        this.loginName = loginName;
//        this.password = password;
//        this.sex = sex;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getNick() {
//        return nick;
//    }
//
//    public void setNick(String nick) {
//        this.nick = nick;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public int getPoneNumber() {
//        return poneNumber;
//    }
//
//    public void setPoneNumber(int poneNumber) {
//        this.poneNumber = poneNumber;
//    }
//
//    public String getLoginName() {
//        return loginName;
//    }
//
//    public void setLoginName(String loginName) {
//        this.loginName = loginName;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public int getSex() {
//        return sex;
//    }
//
//    public void setSex(int sex) {
//        this.sex = sex;
//    }
//
//    public List<BodySize> getListBodySize() {
//        return listBodySize;
//    }
//
//    public void setListBodySize(List<BodySize> listBodySize) {
//        this.listBodySize = listBodySize;
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", firstName='" + firstName + '\'' +
//                ", nick='" + nick + '\'' +
//                ", email='" + email + '\'' +
//                ", poneNumber=" + poneNumber +
//                ", loginName='" + loginName + '\'' +
//                ", password='" + password + '\'' +
//                ", sex=" + sex +
//                ", listBodySize=" + listBodySize +
//                '}';
//    }
//}
