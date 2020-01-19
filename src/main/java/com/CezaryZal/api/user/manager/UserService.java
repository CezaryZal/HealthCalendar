package com.CezaryZal.api.user.manager;

import com.CezaryZal.api.user.manager.mapper.UserToDtoConverter;
import com.CezaryZal.api.user.manager.repo.UserRepoService;
import com.CezaryZal.api.user.UserRepository;
import com.CezaryZal.api.user.entity.User;
import com.CezaryZal.api.user.entity.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService extends UserRepoService{

    private final UserToDtoConverter userToDtoConverter;

    @Autowired
    public UserService(UserRepository userRepository,
                       UserToDtoConverter userToDtoConverter) {
        super(userRepository);
        this.userToDtoConverter = userToDtoConverter;
    }

    public UserDto getUserDtoById(Long id) {
        return userToDtoConverter.mappingEntity(getUserById(id));
    }

    public UserDto getUserDtoByLoginName(String loginName){
        return userToDtoConverter.mappingEntity(getUserByLoginName(loginName));
    }

    public List<UserDto> getUsersDto(){
        return getUsers().stream()
                .map(userToDtoConverter::mappingEntity)
                .collect(Collectors.toList());
    }

    public String deleteUser (Long id) {
        deleteUserById(id);
        return "Skrót dnia o przesłanym id został usuniety";
    }
}
