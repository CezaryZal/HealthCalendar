package com.CezaryZal.api.user.manager;

import com.CezaryZal.api.user.manager.mapper.UserConverter;
import com.CezaryZal.api.user.manager.repo.UserRepoService;
import com.CezaryZal.api.user.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepoService userRepoService;
    private final UserConverter userConverter;

    @Autowired
    public UserService(UserRepoService userRepoService, UserConverter userConverter) {
        this.userRepoService = userRepoService;
        this.userConverter = userConverter;
    }

    public UserDto getUserDtoById(Long id) {
        return userConverter.mappingUserToDto(userRepoService.getUserById(id));
    }

    public UserDto getUserDtoByLoginName(String loginName){
        return userConverter.mappingUserToDto(userRepoService.getUserByLoginName(loginName));
    }

    public List<UserDto> getUsersDto(){
        return userRepoService.getUsers().stream()
                .map(userConverter::mappingUserToDto)
                .collect(Collectors.toList());
    }

    public String deleteUser (Long id) {
        userRepoService.deleteUserById(id);
        return "Skrót dnia o przesłanym id został usuniety";
    }
}
