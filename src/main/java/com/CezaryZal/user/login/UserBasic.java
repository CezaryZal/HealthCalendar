package com.CezaryZal.user.login;

public class UserBasic {

    private Long userId;
    private String nick;
    private String loginName;

    public UserBasic(Long userId, String nick, String loginName) {
        this.userId = userId;
        this.nick = nick;
        this.loginName = loginName;
    }

    public Long getUserId() {
        return userId;
    }

    public String getNick() {
        return nick;
    }

    public String getLoginName() {
        return loginName;
    }
}
