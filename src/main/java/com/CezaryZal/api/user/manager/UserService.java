package com.CezaryZal.api.user.manager;

import com.CezaryZal.api.user.respository.UserRepository;
import com.CezaryZal.api.user.entity.User;
import com.CezaryZal.api.user.entity.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private UserRepository userR;
    private UserObjectConverter converter;

    @Autowired
    public UserService(UserRepository userR, UserObjectConverter converter) {
        this.userR = userR;
        this.converter = converter;
    }

    public User getUserById(Long id) throws AccountNotFoundException {
        return userR.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("User not found by id"));
    }

    public UserDTO getUserDTOById(Long id) throws AccountNotFoundException {
        User user = getUserById(id);

        return converter.convertUserToUserDTO(user);
    }

//    public User getUserByLoginName(String loginName){
//        return userR.findByLoginName(loginName);
//    }

    public List<User> getAllUsers(){
        return (List<User>) userR.findAll();
    }

    public List<UserDTO> getAllUsersDTO(){
        List<User> listUsersDB = getAllUsers();

        List<UserDTO> listUserDTO = new ArrayList<>();
        for (User user : listUsersDB){
            listUserDTO.add(converter.convertUserToUserDTO(user));
        }
        return listUserDTO;
    }

    public boolean addUser(User user){
        userR.save(user);

        return true;
    }

    public boolean updateUser(User user){
        userR.save(user);

        return true;
    }

    public void deleteUserById (Long id) {
        userR.deleteById(id);
    }
}
