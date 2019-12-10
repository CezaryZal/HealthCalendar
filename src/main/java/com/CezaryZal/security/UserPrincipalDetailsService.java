//package com.CezaryZal.security;
//
//import com.CezaryZal.user.User;
//import com.CezaryZal.user.UserService;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserPrincipalDetailsService implements UserDetailsService {
//
//    private UserService userService;
//
//    public UserPrincipalDetailsService(UserService userService) {
//        this.userService = userService;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        User user = this.userService.getUserByLoginName(s);
//        UserPrincipal userPrincipal = new UserPrincipal(user);
//
//        return userPrincipal;
//    }
//}
