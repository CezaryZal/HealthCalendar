package com.CezaryZal.user;

import org.springframework.stereotype.Service;

import javax.persistence.PostLoad;
import javax.persistence.Transient;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private UserRepository UserR;

    public UserService(UserRepository URepository) {
        this.UserR = URepository;
    }


    public User getUserById(Long id){
        return UserR.findById(id);
    }

    public UserDTO getUserDTOById(Long id){
        User user = getUserById(id);

        return convertToUserDTO(user);
    }

    public List<User> getAllUsers(){
        return UserR.getAll();
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
        UserR.save(user);

        return true;
    }

    public boolean updateUser(User user){
        UserR.update(user);

        return true;
    }

    public String deleteUserById (Long id) {
        User user = UserR.findById(id);
        if(UserR.delete(user)){
            return "delete record";
        }
        return "User id not found";
    }

    public UserDTO convertToUserDTO(User user){
        return new UserDTO(user.getId(),
                user.getFirstName(),
                user.getNick(),
                user.getEmail(),
                user.getPoneNumber(),
                user.getLoginName(),
                user.getPassword(),
                user.getSex(),
                user.getAge(),
                user.getDailyLimits()
        );
    }

}
