package com.server.EmailAuthentication.service;

import com.server.EmailAuthentication.domain.Member;

public interface AuthService {
    void signUpUser(Member member);

    Member loginUser(String id, String password);
}
