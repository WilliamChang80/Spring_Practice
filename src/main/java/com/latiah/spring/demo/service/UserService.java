package com.latiah.spring.demo.service;

import com.latiah.spring.demo.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public void createUser(User user);
    public void updateUser(User user, Long userID);
    public User getUserByID(Long userID);
    public void deleteUser(Long userID);
}
