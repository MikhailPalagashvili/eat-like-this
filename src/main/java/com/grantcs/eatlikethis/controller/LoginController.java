package com.grantcs.eatlikethis.controller;

import com.grantcs.eatlikethis.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping(value = {"/login"})
public class LoginController {
    @GetMapping
    public String getLogin() {
        log.info("inside get login method");
        return "login";
    }

    @PostMapping
    public String postLogin(@ModelAttribute final User user) {
        return "redirect:/index";
    }
}
