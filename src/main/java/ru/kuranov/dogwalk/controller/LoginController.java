package ru.kuranov.dogwalk.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kuranov.dogwalk.model.service.interfaces.WalkerService;

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
