package com.anyanguni.smartcctv.controller;

import ch.qos.logback.core.model.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class home {
    @GetMapping("/")
    public String home(){
        return "member/login";
    }
}
