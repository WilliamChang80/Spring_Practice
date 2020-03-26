package com.latiah.spring.demo.controller;

import com.latiah.spring.demo.domain.User;
import com.latiah.spring.demo.domain.base.BaseDto;
import com.latiah.spring.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<BaseDto> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(new BaseDto(users, true, 200));
    }

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<BaseDto> createUser(@RequestBody User user) {
        userService.createUser(user);
        return ResponseEntity.ok(new BaseDto(user,true,200));
    }

    @RequestMapping(value = "/{userID}", method = RequestMethod.PUT)
    ResponseEntity<BaseDto> updateUser(@RequestBody User user, @PathVariable Long userID) {
        userService.updateUser(user, userID);
        return ResponseEntity.ok(new BaseDto(user,true,200));
    }

    @RequestMapping("/{userID}")
    ResponseEntity<BaseDto> getUserByID(@PathVariable Long userID) {
        User user = userService.getUserByID(userID);
        return ResponseEntity.ok(new BaseDto(user,true,200));
    }

    @RequestMapping(value = "/{userID}", method = RequestMethod.DELETE)
    ResponseEntity<BaseDto> deleteUser(@PathVariable Long userID) {
        userService.deleteUser(userID);
        return ResponseEntity.ok(new BaseDto("User has been deleted",true,200));
    }
}
