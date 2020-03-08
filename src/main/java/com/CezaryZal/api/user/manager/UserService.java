package com.CezaryZal.api.user.manager;

import com.CezaryZal.api.user.model.AccountEntity;
import com.CezaryZal.api.user.model.UserDto;
import com.CezaryZal.api.user.model.entity.User;
import com.CezaryZal.api.user.repo.UserRepository;
import com.CezaryZal.authentication.manager.UserAuthService;
import com.CezaryZal.authentication.model.AuthenticationRequest;
import com.CezaryZal.authentication.model.ObjectToAuthResponse;
import com.CezaryZal.exceptions.not.found.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;
    private final UserDtoCreator userDtoCreator;
    private final NewAccountCreator newAccountCreator;
    private final UpdateUser updateUser;
    private final UserAuthService userAuthService;

    @Autowired
    public UserService(UserRepository userRepository,
                       UserConverter userConverter,
                       UserDtoCreator userDtoCreator,
                       NewAccountCreator newAccountCreator,
                       UpdateUser updateUser,
                       UserAuthService userAuthService) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
        this.userDtoCreator = userDtoCreator;
        this.newAccountCreator = newAccountCreator;
        this.updateUser = updateUser;
        this.userAuthService = userAuthService;
    }

    public UserDto getBasicUserDtoById(Long id) {
        return userConverter.mappingUserToDto(getUserById(id));
    }

    public UserDto getUserByUserId(Long userId) {
        User user = getUserById(userId);
        return userDtoCreator.createUserDtoByUser(user);
    }

    public UserDto getUserDtoByLoginName(String loginName) {
        return userConverter.mappingUserToDto(getUserByLoginName(loginName));
    }

    public User getUserByLoginName(String loginName) {
        return userRepository.findByLoginName(loginName)
                .orElseThrow(() -> new UserNotFoundException("User not found by login name"));
    }

    public Long getIdByLoginName(String loginName) {
        return userRepository.getUserIdByLoginName(loginName)
                .orElseThrow(() -> new UserNotFoundException("User not found by login name"));
    }

    public String getNickByUserId(Long userId) {
        return userRepository.getNick(userId)
                .orElse("Nick name has not yet been saved");
    }

    public ObjectToAuthResponse getObjectToAuthResponse(String loginName) {
        return userRepository.getResultToAuthResponse(loginName)
                .orElseThrow(() -> new UserNotFoundException("User not found by login name"));
    }

    public List<UserDto> getUsersDto() {
        return userRepository.findAll()
                .stream()
                .map(userDtoCreator::createUserDtoByUser)
                .collect(Collectors.toList());
    }

    public String createNewAccount(AccountEntity accountEntity) {
        User newUser = newAccountCreator.createAccountByAccountEntity(accountEntity);
        userRepository.save(newUser);
        return "Received the AccountEntity object has been saved to the database";
    }

    //not optimal solution, make a special query with the UPDATE method
    public String updateUser(AccountEntity accountEntity, Long userId) {
        User user = updateUser.updateByAccountEntity(getUserById(userId), accountEntity);
        userRepository.save(user);
        return "Received the AccountEntity object has been updated";
    }

    public String updateUserSecretData(AuthenticationRequest authenticationRequest, Long userId) {
        updateUser.updatePasswordOfUser(authenticationRequest, userId);
        return "Received the AccountEntity object has been updated";
    }

    public String deleteUser(Long id) {
        userRepository.deleteById(id);
        return "The user has been removed based on Id";
    }

    private User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found by id"));
    }
}
