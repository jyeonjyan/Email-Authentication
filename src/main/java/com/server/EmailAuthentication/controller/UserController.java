package com.server.EmailAuthentication.controller;

import com.server.EmailAuthentication.domain.User;
import com.server.EmailAuthentication.dto.UserDto;
import com.server.EmailAuthentication.service.EmailService;
import com.server.EmailAuthentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> signup(
            @Valid @RequestBody UserDto userDto
    ) {
        return ResponseEntity.ok(userService.signup(userDto));
    }

    @Autowired
    private EmailService emailService;

    @GetMapping(value = "/sendmail")
    public String sendMail(){
        emailService.sendMail("s20062@gsm.hs.kr", "SpringBoot 를 사용한 이메일 인증 구현 로직입니다.", "비밀번호 인증을 하시려면 위 번호를 입력해주세요.");

        return "emailSent";
    }
}