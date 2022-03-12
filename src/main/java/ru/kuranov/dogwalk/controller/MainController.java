package ru.kuranov.dogwalk.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

    @GetMapping
    public String mainPage() {
        return "index";
    }

    @GetMapping("/owner")
    public String ownerPage() {
        return "owner";
    }

    @GetMapping("/walker")
    public String walkerPage() {
        return "walker";
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "aboutPage";
    }

    @GetMapping("/contact")
    public String contactPage() {
        return "contactPage";
    }
}
