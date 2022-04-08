package com.cafe24.meet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("basic-template")
    public String basicTemplate() {
        return "basic-template";
    }
}
