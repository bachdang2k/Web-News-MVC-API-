package com.javadev.webnewsMVC.security.userPrincipal;

import com.javadev.webnewsMVC.entity.user.User;
import com.javadev.webnewsMVC.repository.IUserRepository;
import com.javadev.webnewsMVC.services.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private UserServiceImpl userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUserName(username).orElseThrow(
                () -> new UsernameNotFoundException("User not found -> user name or password " + username)
        );
        return UserPrincipal.build(user);
    }

    //Function get current User to perform the operations with database
    public User getCurrentUser(){
        Optional<User> user;
        String username;
        //get an object principal in SecurityContextHolder
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //compare obj with UserDetails if true then userName = principal.getUsername();
        if(principal instanceof UserDetails){
            username = ((UserDetails) principal).getUsername();
        } else {
            //if != present user then userName = principal.toString();
            username = principal.toString();
        }
        //check if userName exist in DB then user = searchUser(userName) in DB
        if(userRepository.existsByUserName(username)){
            user = userService.getUserByUserName(username);
        } else {
            //If not yet exist then return an object of User class by Optional.of
            user = Optional.of(new User());
            user.get().setUserName("Anonymous");
        }
        return user.get();
    }
}
