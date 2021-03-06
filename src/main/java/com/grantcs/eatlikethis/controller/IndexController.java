package com.grantcs.eatlikethis.controller;

import com.grantcs.eatlikethis.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping({"/", "/index", "/index.html"})
public class IndexController {
    @GetMapping
    public String getHomePage(final Model model) {
        return "index";
    }
}
