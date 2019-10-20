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
        UserR.save(user);

        return true;
    }

    public boolean updateUser(UserDB userDB){
        UserR.update(userDB);

        return true;
    }

    public String deleteUserById (int id) {
        UserDB userDB = UserR.getUserDBById(id);
        if(UserR.delete(userDB)){
            return "delete record";
        }
        return "User id not found";
    }

    public UserDB getUserDBById(int id){
        UserDB user = UserR.getUserDBById(id);

        return user;
    }

    public List<UserDB> getAllUsersDB(){
        List<UserDB> listUsersDB = UserR.getAll();

        return listUsersDB;
    }

    public User convertUserClass (UserDB userDB){
        User user = new User(userDB.getId(),
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
