package ru.kuranov.dogwalk.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.kuranov.dogwalk.model.dto.owner.OwnerDto;
import ru.kuranov.dogwalk.model.entity.owner.Owner;
import ru.kuranov.dogwalk.model.mapper.interfaces.OwnerMapper;
import ru.kuranov.dogwalk.model.service.interfaces.OwnerService;
import ru.kuranov.dogwalk.util.ErrorsHandler;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/registration/owner")
public class OwnerRegistrationController {

    private final OwnerService ownerService;
    private final OwnerMapper ownerMapper;
    private final ErrorsHandler errorsHandler;

    @GetMapping
    public String registrationOwner(Model model) {
        if (model.containsAttribute("ownerDto")) {
            return "registration-owner";
        } else {
            OwnerDto ownerDto = OwnerDto.builder().build();
            model.addAttribute("ownerDto", ownerDto);
            return "registration-owner";
        }
    }

//    @PostMapping
//    public String registrationOwner(@Valid OwnerDto ownerDto,
//                                    RedirectAttributes attributes,
//                                    BindingResult bindingResult) {
//        Owner owner = ownerMapper.getOwner(ownerDto);
//        ownerService.save(owner);
//        return "redirect:/";
//    }
//
//    @ExceptionHandler({BindException.class})
//    public String handleException(Model model, BindingResult bindingResult, RedirectAttributes attributes) {
//        if (bindingResult.hasErrors()) {
//            OwnerDto ownerDto = (OwnerDto) bindingResult.getTarget();
//            attributes.addFlashAttribute("ownerDto", ownerDto);
//            attributes.addFlashAttribute("errors", errorsHandler.getErrors(bindingResult));
////            model.addAttribute("errors", errorsHandler.getErrors(bindingResult));
//        }
//        return "redirect:/registration/owner";
//    }

    @PostMapping
    public String registrationOwner(@Valid OwnerDto ownerDto,
                                    RedirectAttributes attributes,
                                    BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/registration/owner";
        }
        Owner owner = ownerMapper.getOwner(ownerDto);
        ownerService.save(owner);
        return "redirect:/";
    }

}
