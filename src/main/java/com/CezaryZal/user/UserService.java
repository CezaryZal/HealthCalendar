package com.CezaryZal.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserService {

    private UserRepository URepository;

    @Autowired
    public UserService(UserRepository URepository) {
        this.URepository = URepository;
    }

    public User findById(int id){
        User user = URepository.findById(id);

        return user;
    }

//    public List<User> getUsers(){
//        return userRepository.getUsers();
//    }

    public boolean addUser(User user){
        URepository.save(user);

        return true;
    }

}
