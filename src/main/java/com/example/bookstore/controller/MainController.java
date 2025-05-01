package com.example.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    // 메인 페이지 요청 처리
    @GetMapping("/")
    public String index() {
        return "index";  // index.html 뷰 반환
    }
}
