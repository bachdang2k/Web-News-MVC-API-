package com.javadev.webnewsMVC.services.Impl;

import com.javadev.webnewsMVC.dto.UserDTO;
import com.javadev.webnewsMVC.entity.user.User;
import com.javadev.webnewsMVC.repository.IUserRepository;
import com.javadev.webnewsMVC.services.IUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserServices {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<UserDTO> getAllUser() {
        return null;
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> getUserByGmail(String gmail) {
        return Optional.empty();
    }

    @Override
    public Optional<User> getUserByUserName(String userName) {
        return Optional.empty();
    }

    @Override
    public User saveUser(User user) {
        return null;
    }

    @Override
    public User updateUserByID(User newUser, Long id) {
        return null;
    }

    @Override
    public User updateUserByEmail(User newUser, String email) {
        return null;
    }

    @Override
    public Boolean existsByEmail(String email) {
        return null;
    }
}
