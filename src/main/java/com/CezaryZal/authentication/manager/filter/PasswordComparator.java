package com.CezaryZal.authentication.manager.filter;

import com.CezaryZal.exceptions.InvalidPasswordException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class PasswordComparator {

    public void throwIfIsNotEqualsPassword(String passwordFromUserLogin, String userPasswordFromDb) {
        if (!BCrypt.checkpw(passwordFromUserLogin, userPasswordFromDb)){
            throw new InvalidPasswordException("Input password is incorrect");
        }
    }
}
