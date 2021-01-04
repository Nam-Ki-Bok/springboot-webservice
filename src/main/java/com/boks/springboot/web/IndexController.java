package com.boks.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
}

// Mustache 스타터 덕분에 src/main/resources/index.mustache 로 자동 전환