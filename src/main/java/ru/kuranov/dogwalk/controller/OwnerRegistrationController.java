package ru.kuranov.dogwalk.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kuranov.dogwalk.exceptions.ErrorMessages;
import ru.kuranov.dogwalk.model.dto.owner.OwnerDto;
import ru.kuranov.dogwalk.model.entity.owner.Owner;
import ru.kuranov.dogwalk.model.mapper.interfaces.OwnerMapper;
import ru.kuranov.dogwalk.model.service.interfaces.OwnerService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/registration/owner")
public class OwnerRegistrationController {

    private final OwnerService ownerService;
    private final OwnerMapper ownerMapper;

    @GetMapping
    public String registrationOwner(OwnerDto ownerDto) {
        return "registration-owner";
    }

    @PostMapping
    public String registrationOwner(@Valid OwnerDto ownerDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "registration-owner";
        }

        if (ownerService.isThereSuchLogin(ownerDto.getUsername())) {
            model.addAttribute("errorMessage", ErrorMessages.USER_WITH_THIS_LOGIN_ALREADY_EXISTS);
            return "registration-owner";
        }

        Owner owner = ownerMapper.getOwner(ownerDto);
        ownerService.save(owner);
        return "redirect:/registration/getmail";
    }
}
