package ru.kuranov.dogwalk.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kuranov.dogwalk.exceptions.ErrorMessages;
import ru.kuranov.dogwalk.model.dto.walker.WalkerDto;
import ru.kuranov.dogwalk.model.entity.walker.Walker;
import ru.kuranov.dogwalk.model.mapper.interfaces.WalkerMapper;
import ru.kuranov.dogwalk.model.service.interfaces.CitizenshipService;
import ru.kuranov.dogwalk.model.service.interfaces.CityService;
import ru.kuranov.dogwalk.model.service.interfaces.WalkerService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class WalkerRegistrationController {

    private final WalkerService walkerService;
    private final WalkerMapper walkerMapper;
    private final CityService cityService;
    private final CitizenshipService citizenshipService;

    @GetMapping("/registration/walker")
    public String registrationWalker(WalkerDto walkerDto, Model model) {
        walkerDto = WalkerDto.builder()
                .cities(cityService.findAll())
                .citizenships(citizenshipService.findAll())
                .build();
        model.addAttribute("walkerDto", walkerDto);
        return "registration-walker";
    }

    @PostMapping("/registration/walker")
    public String registrationWalker(@Valid WalkerDto walkerDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            walkerDto.setCities(cityService.findAll());
            walkerDto.setCitizenships(citizenshipService.findAll());
            model.addAttribute("walkerDto", walkerDto);
            return "registration-walker";
        }

        if (walkerService.isThereSuchLogin(walkerDto.getUsername())) {
            model.addAttribute("walkerDto", walkerDto);
            model.addAttribute("errorMessage", ErrorMessages.USER_WITH_THIS_LOGIN_ALREADY_EXISTS);
        }

        Walker walker = walkerMapper.getWalker(walkerDto);
        walkerService.save(walker);
        return "redirect:/registration/getmail";
    }

    @GetMapping("/registration/getmail")
    public String postRegistrationPage(Model model) {
        return "registration-getmail";
    }
}
