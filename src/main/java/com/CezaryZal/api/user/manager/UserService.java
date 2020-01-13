package com.CezaryZal.api.user.manager;

import com.CezaryZal.api.user.respository.UserRepository;
import com.CezaryZal.api.user.entity.User;
import com.CezaryZal.api.user.entity.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public User getUserById(Long id){
        return userR.findById(id);
    }

    public UserDTO getUserDTOById(Long id){
        User user = getUserById(id);

        return converter.convertUserToUserDTO(user);
    }

    public User getUserByLoginName(String loginName){
        return userR.findByLoginName(loginName);
    }

    public Long getUserIdByLoginName(String loginName){
        return userR.findUserIdByLoginName(loginName);
    }

    public List<User> getAllUsers(){
        return userR.getAll();
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
        userR.update(user);

        return true;
    }

    public String deleteUserById (Long id) {
        User user = userR.findById(id);
        if(userR.delete(user)){
            return "delete record";
        }
        return "User id not found";
    }

}
