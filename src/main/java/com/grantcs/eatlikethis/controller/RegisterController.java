package com.grantcs.eatlikethis.controller;


import com.grantcs.eatlikethis.model.User;
import com.grantcs.eatlikethis.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegisterController(final UserRepository userRepository, final PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String getRegisterForm(final Model model) {
        model.addAttribute("user", new User());
        return "registerForm";
    }

    @PostMapping
    public String processRegisterForm(@Validated @ModelAttribute final User user) {
        final User secureUser = user.secureUser(passwordEncoder);
        userRepository.save(secureUser);
        return "redirect:/login";
    }
}
