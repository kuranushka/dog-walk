package ru.kuranov.dogwalk.controller.owner;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/profile/owner")
public class OwnerProfileController {

    @GetMapping
    public String getProfilePage() {
        return "owner";
    }
    //TODO сделать личный кабинет
    //TODO сделать активацию регистрации через почту
}
