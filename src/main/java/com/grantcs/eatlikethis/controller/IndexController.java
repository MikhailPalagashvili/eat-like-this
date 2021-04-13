package com.grantcs.eatlikethis.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping(value = {"/", "/index", "/index.html"})
public class IndexController {
    @GetMapping
    public String getHomePage() {
        return "index";
    }
}