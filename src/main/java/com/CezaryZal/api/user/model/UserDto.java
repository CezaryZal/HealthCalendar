package com.CezaryZal.api.user.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
public class UserDto {

    private Long id;
    private String loginName;
    private String nick;
    private String email;
    private int phoneNumber;
    private int sex;
    private int age;


    public static Builder builder(){
        return new Builder();
    }

    public static final class Builder{
        private Long id;
        private String loginName;
        private String nick;
        private String email;
        private int phoneNumber;
        private int sex;
        private int age;

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
        public Builder phoneNumber(int phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }
        public Builder sex(int sex){
            this.sex = sex;
            return this;
        }
        public Builder age(int age){
            this.age = age;
            return this;
        }

        public UserDto build(){
            UserDto userDto = new UserDto();
            userDto.id = this.id;
            userDto.loginName = this.loginName;
            userDto.nick = this.nick;
            userDto.email = this.email;
            userDto.phoneNumber = this.phoneNumber;
            userDto.sex = this.sex;
            userDto.age = this.age;
            return userDto;
        }
    }
}
