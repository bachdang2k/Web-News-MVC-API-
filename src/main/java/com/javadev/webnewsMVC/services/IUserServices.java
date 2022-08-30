package com.javadev.webnewsMVC.services;

import com.javadev.webnewsMVC.dto.UserDTO;
import com.javadev.webnewsMVC.entity.user.User;

import java.util.List;
import java.util.Optional;

public interface IUserServices {

    List<UserDTO> getAllUser();
    Optional<User> getUserById(Long id);
    Optional<User> getUserByGmail(String gmail);
    Optional<User> getUserByUserName(String userName);
    User saveUser(User user);
    User updateUserByID(User newUser, Long id);
    User updateUserByEmail(User newUser, String email);
    Boolean existsByEmail(String email);

}
