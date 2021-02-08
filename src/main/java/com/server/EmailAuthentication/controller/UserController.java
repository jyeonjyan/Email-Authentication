package com.server.EmailAuthentication.controller;

import com.server.EmailAuthentication.dto.UserDto;
import com.server.EmailAuthentication.service.EmailService;
import com.server.EmailAuthentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private EmailService mss;

    @PostMapping("/signup")
    public void signUp(@RequestBody UserDto userDto){
        //DB에 기본 정보 insert
        userService.signup(userDto);

        //임의의 authKey 생성 & 이메일 발송
        String authKey = mss.sendAuthMail(userDto.getUserEmail());
    }

    @GetMapping("member/signUpConfirm")
    public void signUpConfirm(@RequestParam String email){
        //email, authKey 가 일치할경우 authStatus 업데이트
        userService.updateAuthStatus(email);
        System.out.println("email = " + email);
        //리다이렉트
    }
}