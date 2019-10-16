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
        UserAllInf userAllInf = getUserAllInfById(id);
        User user = convertUserClass(userAllInf);

        return user;
    }

    public List<User> getAllUsers(){
        List<UserAllInf> listUsersAllInf = getAllUsersAllInf();

        List<User> listUsers = new ArrayList<>();
        for (UserAllInf userAllInf : listUsersAllInf){
            listUsers.add(convertUserClass(userAllInf));
        }
        return listUsers;
    }

    public boolean addUser(UserAllInf user){
        URepository.save(user);

        return true;
    }

    public boolean updateUser(UserAllInf userAllInf){
        URepository.update(userAllInf);

        return true;
    }

    public String delete (int id) {
        UserAllInf userAllInf = URepository.getUserAllInfById(id);
        if(URepository.delete(userAllInf)){
            return "delete record";
        }
        return "User id not found";
    }

    public UserAllInf getUserAllInfById(int id){
        UserAllInf user = URepository.getUserAllInfById(id);

        return user;
    }

    public List<UserAllInf> getAllUsersAllInf(){
        List<UserAllInf> listUsersAllInf = URepository.getAllUsers();

        return listUsersAllInf;
    }

    public User convertUserClass (UserAllInf userAllInf){
        User user = new User(userAllInf.getId(), userAllInf.getFirstName(), userAllInf.getNick(), userAllInf.getEmail(),
                userAllInf.getPoneNumber(), userAllInf.getLoginName(), userAllInf.getPassword(), userAllInf.getSex());

        return user;
    }

}
