package com.cos.photogramstart.web;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.service.AuthService;
import com.cos.photogramstart.web.dto.auth.SignupDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller //IoC 등록, 파일을 리턴하는 컨트롤러
public class AuthController {

    private static final Logger log = LoggerFactory.getLogger(AuthController.class);

    // 자바에서는 전역변수에 final이 걸려있으면 초기화를 생성자 실행 or 객체가 만들어질 때 무조건 해줘야함
    private final AuthService authService;

    @GetMapping("/auth/signin")
    public String signinForm() {
        return "auth/signin";
    }

    @GetMapping("/auth/signup")
    public String signupForm() {
        return "auth/signup";
    }

    // 회원가입 버튼 -> /auth/signup -> auth/signin
    @PostMapping("/auth/signup")
    public String signup(SignupDto signupDto) { // key=value (x-www-form-urlencoded)
        log.info(signupDto.toString());

        // User <- SignupDto
        User user = signupDto.toEntity();
        log.info(user.toString());

        User userEntity = authService.회원가입(user);
        System.out.println(userEntity);

        return "auth/signin";
    }
}
