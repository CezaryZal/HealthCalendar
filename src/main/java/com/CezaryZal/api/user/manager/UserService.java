package com.CezaryZal.api.user.manager;

import com.CezaryZal.api.user.model.UserDto;
import com.CezaryZal.api.user.model.entity.User;
import com.CezaryZal.api.user.repo.UserRepository;
import com.CezaryZal.authentication.model.ObjectToAuthResponse;
import com.CezaryZal.exceptions.not.found.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    @Autowired
    public UserService(UserRepository userRepository, UserConverter userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }

    public UserDto getUserDtoById(Long id) {
        return userConverter.mappingUserToDto(getUserById(id));
    }

    public UserDto getUserDtoByLoginName(String loginName){
        return userConverter.mappingUserToDto(getUserByLoginName(loginName));
    }

    public List<UserDto> getUsersDto(){
        return userRepository.findAll()
                .stream()
                .map(userConverter::mappingUserToDto)
                .collect(Collectors.toList());
    }

    public String deleteUser (Long id) {
        userRepository.deleteById(id);
        return "Skrót dnia o przesłanym id został usuniety";
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found by id"));
    }

    public User getUserByLoginName(String loginName){
        return userRepository.findByLoginName(loginName)
                .orElseThrow(() -> new UserNotFoundException("User not found by login name"));
    }

    public Long getIdByLoginName(String loginName){
        return userRepository.getUserIdByLoginName(loginName)
                .orElseThrow(() -> new UserNotFoundException("User not found by login name"));
    }

    public String getNickByUserId(Long userId){
        return userRepository.getNick(userId)
                .orElse("Nick nie został jeszcze dopisany");
    }

    public ObjectToAuthResponse getObjectToAuthResponse(String loginName){
        return userRepository.getResultToAuthResponse(loginName)
                .orElseThrow(() -> new UserNotFoundException("User not found by login name"));
    }

    public User addUser(User user){
        return userRepository.save(user);
    }

    public void updateUser(User user){
        userRepository.save(user);
    }

}
