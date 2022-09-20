package com.cos.photogramstart.web.dto.auth;

import lombok.Data;

@Data // Getter, Setter를 생성
public class SignupDto {

    private String username;

    private String password;

    private String email;

    private String name;
}
