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

    public User getUserById(int id){
        UserAllInf userAllInf = URepository.getUserAllInfById(id);

        User user = new User(userAllInf.getId(), userAllInf.getFirstName(), userAllInf.getNick(), userAllInf.getEmail(),
                userAllInf.getPoneNumber(), userAllInf.getLoginName(), userAllInf.getPassword(), userAllInf.getSex());

        return user;
    }

//    public List<User> getUsers(){
//        return userRepository.getUsers();
//    }

    public boolean addUser(User user){
        URepository.save(user);

        return true;
    }

    public UserAllInf getUserAllInfById(int id){
        UserAllInf user = URepository.getUserAllInfById(id);

        return user;
    }

}
