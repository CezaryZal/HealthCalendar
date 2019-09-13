package com.CezaryZal.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public List<User> getUsers(){
        return userRepository.getUsers();
    }

    @Transactional
    public User getUser(int id){
        return userRepository.getUser(id);
    }


}
