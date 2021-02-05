package com.server.EmailAuthentication.controller;

import com.server.EmailAuthentication.domain.User;
import com.server.EmailAuthentication.dto.UserDto;
import com.server.EmailAuthentication.service.EmailService;
import com.server.EmailAuthentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

//
//    @PostMapping("/signup")
//    public ResponseEntity<User> signup(
//            @Valid @RequestBody UserDto userDto
//    ) {
//        return ResponseEntity.ok(userService.signup(userDto));
//    }

//
//    @GetMapping(value = "/sendmail")
//    public String sendMail(){
//        emailService.sendMail("s20062@gsm.hs.kr", "SpringBoot 를 사용한 이메일 인증 구현 로직입니다.", "비밀번호 인증을 하시려면 위 번호를 입력해주세요.");
//
//        return "emailSent";
//    }
}