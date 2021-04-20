package com.grantcs.eatlikethis.controller;

import com.grantcs.eatlikethis.model.User;
import com.grantcs.eatlikethis.validation.GroupOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping(value = {"/login"})
public class LoginController {
    @GetMapping
    public String getLogin(final Model model) {
        log.info("inside get login method");
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping
    public String postLogin(@Validated(GroupOrder.class) @ModelAttribute final User user, BindingResult errors) {
        if (errors.hasErrors()) {
            return "login";
        }
        log.info("inside post login method");
        return "index";
    }
}
