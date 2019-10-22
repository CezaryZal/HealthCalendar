package com.CezaryZal.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class UserService {

    private UserRepository UserR;

    @Autowired
    public UserService(UserRepository URepository) {
        this.UserR = URepository;
    }


    public User getUserById(int id){
        return UserR.getUserById(id);
    }

    public UserDTO getUserDTOById(int id){
        User user = getUserById(id);

        return convertUserDTO(user);
    }

    public List<User> getAllUsers(){
        return UserR.getAll();
    }

    public List<UserDTO> getAllUsersDTO(){
        List<User> listUsersDB = getAllUsers();

        List<UserDTO> listUserDTO = new ArrayList<>();
        for (User user : listUsersDB){
            listUserDTO.add(convertUserDTO(user));
        }
        return listUserDTO;
    }

    public boolean addUser(User user){
        UserR.save(user);

        return true;
    }

    public boolean updateUser(User user){
        UserR.update(user);

        return true;
    }

    public String deleteUserById (int id) {
        User user = UserR.getUserById(id);
        if(UserR.delete(user)){
            return "delete record";
        }
        return "User id not found";
    }

    public UserDTO convertUserDTO(User user){
        return new UserDTO(user.getId(),
                user.getFirstName(),
                user.getNick(),
                user.getEmail(),
                user.getPoneNumber(),
                user.getLoginName(),
                user.getPassword(),
                user.getSex(),
                user.getDailyLimits()
        );
    }

}
