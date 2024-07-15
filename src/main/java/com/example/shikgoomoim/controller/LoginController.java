package com.example.shikgoomoim.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Tag(name = "로그인 Controller", description = "사용자 로그인 및 인증 관리")
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/login")
public class LoginController {

    @GetMapping("/")
    public String showLoginPage() {
        // 로그인 페이지를 반환합니다.
        return "login";
    }

    @PostMapping("/login")
    public String handleLogin() {
        // 로그인 처리 로직을 여기에 추가할 수 있습니다.
        // 보통 Spring Security가 자동으로 처리를 합니다.
        return "redirect:/home";
    }

    // 로그아웃은 Spring Security에서 자동으로 처리하는 경우가 많습니다.
    // 만약 로그아웃을 수동으로 처리해야 한다면 여기에 추가합니다.
}
