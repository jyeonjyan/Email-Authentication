package com.server.EmailAuthentication.dto;


import com.sun.istack.NotNull;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    @Email
    @NotNull
    private String userEmail = "s20062@gsm.hs.kr";

    @NotNull
    private String password = "1234";

    @NotNull
    @Size(min = 3, max = 30)
    private String userName = "전지";

    private String authKey;
}
