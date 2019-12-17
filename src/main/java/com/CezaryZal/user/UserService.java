package com.CezaryZal.user;

//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private UserRepository userR;

    public UserService(UserRepository URepository) {
        this.userR = URepository;
    }


    public User getUserById(Long id){
        return userR.findById(id);
    }

    public UserDTO getUserDTOById(Long id){
        User user = getUserById(id);

        return convertToUserDTO(user);
    }

    public User getUserByLoginName(String loginName){
        return userR.findByLoginName(loginName);
    }

    public List<User> getAllUsers(){
        return userR.getAll();
    }

    public List<UserDTO> getAllUsersDTO(){
        List<User> listUsersDB = getAllUsers();

        List<UserDTO> listUserDTO = new ArrayList<>();
        for (User user : listUsersDB){
            listUserDTO.add(convertToUserDTO(user));
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

    public UserDTO convertToUserDTO(User user){
        return new UserDTO(user.getId(),
                user.getFirstName(),
                user.getNick(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getSex(),
                user.getAge(),
                user.getDailyLimits()
        );
    }

}
