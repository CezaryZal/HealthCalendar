package com.CezaryZal.api.user.manager;

import com.CezaryZal.api.body.manager.BodySizeService;
import com.CezaryZal.api.body.model.BodySizeDto;
import com.CezaryZal.api.day.manager.DayService;
import com.CezaryZal.api.day.model.DayDto;
import com.CezaryZal.api.user.model.UserDto;
import com.CezaryZal.api.user.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDtoCreator {

    private final DayService dayService;
    private final BodySizeService bodySizeService;

    @Autowired
    public UserDtoCreator(DayService dayService, BodySizeService bodySizeService) {
        this.dayService = dayService;
        this.bodySizeService = bodySizeService;
    }

    public UserDto createUserDtoByUser(User user){
        List<BodySizeDto> listBodySizeDtoByUserId = bodySizeService.getListBodySizeDtoByUserId(user.getId());
        List<DayDto> daysDtoByUserId = dayService.getDaysDtoByUserId(user.getId());

        return UserDto.builder()
                .id(user.getId())
                .loginName(user.getLoginName())
                .nick(user.getNick())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .man(user.isMan())
                .birthDate(user.getBirthDate())
                .userAuthentication(user.getUserAuthentication())
                .listBodySizeDto(listBodySizeDtoByUserId)
                .listDayDto(daysDtoByUserId)
                .build();
    }
}
