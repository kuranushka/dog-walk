package ru.kuranov.dogwalk.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kuranov.dogwalk.model.entity.security.AccountUser;
import ru.kuranov.dogwalk.model.entity.walker.Walker;
import ru.kuranov.dogwalk.model.service.interfaces.AccountUserService;
import ru.kuranov.dogwalk.model.service.interfaces.WalkerService;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final WalkerService walkerService;

    @GetMapping("/login")
    public String getLoginPage() {
//        Optional<Walker> walker = walkerService.findByUsername("walker");
//        System.out.println();
        return "login";
    }

//    @PostMapping
//    public String login(@RequestParam String username, @RequestParam String password) {
//        System.out.println();
//        return "redirect:/";
//    }
}
