package ru.kuranov.dogwalk.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class MainController {

    @GetMapping
    public String mainPage(Model model) {
        model.addAttribute("message", "HELLO ANDREY");
        return "index";
    }
}
