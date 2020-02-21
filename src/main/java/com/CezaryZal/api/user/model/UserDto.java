package com.CezaryZal.api.user.model;

import com.CezaryZal.api.body.model.BodySizeDto;
import com.CezaryZal.api.day.model.DayDto;
import com.CezaryZal.authentication.model.entity.UserAuthentication;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

import javax.persistence.Column;
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
    private String phoneNumber;
    private boolean man;
    private int age;
    private LocalDate birthDate;
    private int kcalDemandPerDay;
    private int drinkDemandPerDay;
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
        private String phoneNumber;
        private boolean man;
        private int age;
        private LocalDate birthDate;
        private int kcalDemandPerDay;
        private int drinkDemandPerDay;
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
        public Builder phoneNumber(String phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }
        public Builder man(boolean man){
            this.man = man;
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
        public Builder kcalDemandPerDay(int kcalDemandPerDay){
            this.kcalDemandPerDay = kcalDemandPerDay;
            return this;
        }
        public Builder drinkDemandPerDay(int drinkDemandPerDay){
            this.drinkDemandPerDay = drinkDemandPerDay;
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
            userDto.man = this.man;
            userDto.age = this.age;
            userDto.birthDate = this.birthDate;
            userDto.kcalDemandPerDay = this.kcalDemandPerDay;
            userDto.drinkDemandPerDay = drinkDemandPerDay;
            userDto.userAuthentication = this.userAuthentication;
            userDto.listBodySizeDto = this.listBodySizeDto;
            userDto.listDayDto = this.listDayDto;
            return userDto;
        }
    }
}
