package com.server.EmailAuthentication.controller;

import com.server.EmailAuthentication.dto.UserDto;
import com.server.EmailAuthentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public String save(@RequestBody UserDto userDto){
        return userService.save(userDto);
    }
}
