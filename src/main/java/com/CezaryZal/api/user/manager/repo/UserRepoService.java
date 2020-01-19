package com.CezaryZal.api.user.manager.repo;

import com.CezaryZal.api.user.entity.User;
import com.CezaryZal.api.user.UserRepository;
import com.CezaryZal.exceptions.not.found.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User addUser(User user){
        return userRepository.save(user);
    }

    public void updateUser(User user){
        userRepository.save(user);
    }

    protected void deleteUserById (Long id) {
        userRepository.deleteById(id);
    }

}
