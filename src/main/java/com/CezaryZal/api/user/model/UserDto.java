package com.CezaryZal.api.user.model;

import com.CezaryZal.api.body.model.BodySizeDto;
import com.CezaryZal.api.day.model.DayDto;
import com.CezaryZal.authentication.model.entity.UserAuthentication;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

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
    private LocalDate birthDate;
    private UserAuthentication userAuthentication;
    private List<BodySizeDto> listBodySizeDto;
    private List<DayDto> listDayDto;


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
        private LocalDate birthDate;
        private UserAuthentication userAuthentication;
        private List<BodySizeDto> listBodySizeDto;
        private List<DayDto> listDayDto;

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
        public Builder birthDate(LocalDate birthDate){
            this.birthDate = birthDate;
            return this;
        }
        public Builder userAuthentication(UserAuthentication userAuthentication){
            this.userAuthentication = userAuthentication;
            return this;
        }
        public Builder listBodySizeDto(List<BodySizeDto> listBodySizeDto){
            this.listBodySizeDto = listBodySizeDto;
            return this;
        }
        public Builder listDayDto(List<DayDto> listDayDto){
            this.listDayDto = listDayDto;
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
            userDto.birthDate = this.birthDate;
            userDto.userAuthentication = this.userAuthentication;
            userDto.listBodySizeDto = this.listBodySizeDto;
            userDto.listDayDto = this.listDayDto;
            return userDto;
        }
    }
}
