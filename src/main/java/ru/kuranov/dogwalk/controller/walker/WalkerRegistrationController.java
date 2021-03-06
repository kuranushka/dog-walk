package ru.kuranov.dogwalk.controller.walker;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kuranov.dogwalk.exceptions.ErrorMessages;
import ru.kuranov.dogwalk.model.dto.walker.WalkerDto;
import ru.kuranov.dogwalk.model.entity.main.Walker;
import ru.kuranov.dogwalk.model.mapper.WalkerDtoMapper;
import ru.kuranov.dogwalk.repository.security.AccountUserService;
import ru.kuranov.dogwalk.service.CityService;
import ru.kuranov.dogwalk.service.WalkerService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class WalkerRegistrationController {

    private final WalkerService walkerService;
    private final WalkerDtoMapper walkerDtoMapper;
    private final CityService cityService;
    private final AccountUserService accountUserService;

    @GetMapping("/registration/walker")
    public String registrationWalker(WalkerDto walkerDto, Model model) {
        walkerDto = walkerService.getWalkerDto();
        model.addAttribute("walkerDto", walkerDto);
        return "registration-walker";
    }

    @PostMapping("/registration/walker")
    public String registrationWalker(@Valid WalkerDto walkerDto,
                                     BindingResult bindingResult,
                                     Model model) {
        if (bindingResult.hasErrors()) {
            walkerDto.setCities(cityService.findAll());
            model.addAttribute("walkerDto", walkerDto);
            return "registration-walker";
        }

        if (accountUserService.isThereSuchUsername(walkerDto.getUsername())) {
            model.addAttribute("walkerDto", walkerDto);
            walkerDto.setCities(cityService.findAll());
            model.addAttribute("errorMessage", ErrorMessages.USER_WITH_THIS_LOGIN_ALREADY_EXISTS);
            return "registration-walker";
        }

        Walker walker = walkerDtoMapper.getWalker(walkerDto);
        walkerService.save(walker);
        return "redirect:/registration/getmail";
    }

    @GetMapping("/registration/getmail")
    public String postRegistrationPage(Model model) {
        return "registration-getmail";
    }
}
