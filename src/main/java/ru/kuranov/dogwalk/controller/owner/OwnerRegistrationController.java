package ru.kuranov.dogwalk.controller.owner;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kuranov.dogwalk.exceptions.ErrorMessages;
import ru.kuranov.dogwalk.model.dto.owner.OwnerDto;
import ru.kuranov.dogwalk.model.entity.main.Owner;
import ru.kuranov.dogwalk.model.mapper.OwnerDtoMapper;
import ru.kuranov.dogwalk.repository.security.AccountUserService;
import ru.kuranov.dogwalk.service.OwnerService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/registration/owner")
public class OwnerRegistrationController {

    private final OwnerService ownerService;
    private final OwnerDtoMapper ownerDtoMapper;
    private final AccountUserService accountUserService;

    @GetMapping
    public String registrationOwner(OwnerDto ownerDto) {
        return "registration-owner";
    }

    @PostMapping
    public String registrationOwner(@Valid OwnerDto ownerDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "registration-owner";
        }

        if (accountUserService.isThereSuchUsername(ownerDto.getUsername())) {
            model.addAttribute("errorMessage", ErrorMessages.USER_WITH_THIS_LOGIN_ALREADY_EXISTS);
            return "registration-owner";
        }

        Owner owner = ownerDtoMapper.getOwner(ownerDto);
        ownerService.save(owner);
        return "redirect:/registration/getmail";
    }
}
