package ru.kuranov.dogwalk.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class MainController {

    @GetMapping("1")
    public String mainPage(Model model) {
        model.addAttribute("message", "введите Ваше имя ...");
        return "registration-owner";
    }

    @PostMapping("test")
    public String test(@RequestParam String test) {
        System.out.println(test);
        return "redirect:/";
    }
}
