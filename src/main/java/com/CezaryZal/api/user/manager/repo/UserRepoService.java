package com.CezaryZal.api.user.manager.repo;

import com.CezaryZal.api.user.model.entity.User;
import com.CezaryZal.api.user.UserRepository;
import com.CezaryZal.authentication.model.ObjectToAuthResponse;
import com.CezaryZal.exceptions.not.found.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRepoService {

    private final UserRepository userRepository;

    @Autowired
    public UserRepoService(UserRepository userRepository) {
        this.userRepository = userRepository;
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

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User addUser(User user){
        return userRepository.save(user);
    }

    public void updateUser(User user){
        userRepository.save(user);
    }

    public void deleteUserById (Long id) {
        userRepository.deleteById(id);
    }

}
