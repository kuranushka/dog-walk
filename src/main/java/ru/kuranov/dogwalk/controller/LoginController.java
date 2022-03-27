package ru.kuranov.dogwalk.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kuranov.dogwalk.service.WalkerService;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final WalkerService walkerService;

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }
}
