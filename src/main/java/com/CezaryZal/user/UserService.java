package com.CezaryZal.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
        UserDB userDB = getUserDBById(id);
        User user = convertUserClass(userDB);

        return user;
    }

    public List<User> getAllUsers(){
        List<UserDB> listUsersDB = getAllUsersDB();

        List<User> listUsers = new ArrayList<>();
        for (UserDB userDB : listUsersDB){
            listUsers.add(convertUserClass(userDB));
        }
        return listUsers;
    }

    public boolean addUser(UserDB user){
        URepository.save(user);

        return true;
    }

    public boolean updateUser(UserDB userDB){
        URepository.update(userDB);

        return true;
    }

    public String deleteUserById (int id) {
        UserDB userDB = URepository.getUserDBById(id);
        if(URepository.delete(userDB)){
            return "delete record";
        }
        return "User id not found";
    }

    public UserDB getUserDBById(int id){
        UserDB user = URepository.getUserDBById(id);

        return user;
    }

    public List<UserDB> getAllUsersDB(){
        List<UserDB> listUsersDB = URepository.getAll();

        return listUsersDB;
    }

    public User convertUserClass (UserDB userDB){
        User user = new User(userDB.getId(),
                userDB.getId(),
                userDB.getFirstName(),
                userDB.getNick(),
                userDB.getEmail(),
                userDB.getPoneNumber(),
                userDB.getLoginName(),
                userDB.getPassword(),
                userDB.getSex(),
                userDB.getDailyLimits().getDrinkDemand(),
                userDB.getDailyLimits().getKcalDemand());

        return user;
    }

}
