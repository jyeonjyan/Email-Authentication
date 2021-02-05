package com.server.EmailAuthentication.controller;

import com.server.EmailAuthentication.dto.UserDto;
import com.server.EmailAuthentication.service.EmailService;
import com.server.EmailAuthentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private EmailService mss;

    @RequestMapping("/signup")
    public void signUp(@ModelAttribute UserDto userDto){
        //DB에 기본 정보 insert
        userService.signup(userDto);

        //임의의 authKey 생성 & 이메일 발송
        String authKey = mss.sendAuthMail(userDto.getUserEmail());
        userDto.setAuthKey(authKey);

        Map<String, String> map = new HashMap<String, String>();
        map.put("email", userDto.getUserEmail());
        map.put("authKey", userDto.getAuthKey());
        System.out.println(map);

        //DB에 authKey 업데이트
        userService.updateAuthKey(map);
    }
}