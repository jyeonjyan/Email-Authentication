package com.server.EmailAuthentication.controller;

import com.server.EmailAuthentication.domain.User;
import com.server.EmailAuthentication.dto.UserDto;
import com.server.EmailAuthentication.service.EmailService;
import com.server.EmailAuthentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;


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
//        userDto.setAuthKey(authKey);

//        Map<String, String> map = new HashMap<String, String>();
//        map.put("email", userDto.getUserEmail());
//        map.put("authKey", userDto.getAuthKey());
//        System.out.println(map);
//
//        //DB에 authKey 업데이트
//        userService.updateAuthKey(map);
    }

    @GetMapping("member/signUpConfirm")
    public void signUpConfirm(@RequestParam String email){
        //email, authKey 가 일치할경우 authStatus 업데이트
        userService.updateAuthStatus(email);
        System.out.println("email = " + email);

        //리다이렉트

//        mav.addObject("display", "/view/member/signUp_confirm.jsp");
//        mav.setViewName("/view/index");
//        return mav;
        }
    }