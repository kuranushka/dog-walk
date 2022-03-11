package ru.kuranov.dogwalk.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kuranov.dogwalk.exceptions.ErrorMessages;
import ru.kuranov.dogwalk.model.dto.owner.OwnerDto;
import ru.kuranov.dogwalk.model.entity.owner.Owner;
import ru.kuranov.dogwalk.model.mapper.interfaces.OwnerMapper;
import ru.kuranov.dogwalk.model.service.interfaces.OwnerService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class OwnerRegistrationController {

    private final OwnerService ownerService;
    private final OwnerMapper ownerMapper;

    @GetMapping("/registration/owner")
    public String showAddUserForm(OwnerDto ownerDto) {
        return "contact";
    }

    @PostMapping("/registration/owner")
    public String addUser(@Valid OwnerDto ownerDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "contact";
        }

        if (ownerService.isThereSuchLogin(ownerDto.getLogin())) {
            model.addAttribute("errorMessage", ErrorMessages.USER_WITH_THIS_LOGIN_ALREADY_EXISTS);
            return "contact";
        }

        Owner owner = ownerMapper.getOwner(ownerDto);
        ownerService.save(owner);
        return "redirect:/";
    }
}
