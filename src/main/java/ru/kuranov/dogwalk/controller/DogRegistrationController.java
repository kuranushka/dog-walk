package ru.kuranov.dogwalk.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kuranov.dogwalk.controller.util.DogDtoValidator;
import ru.kuranov.dogwalk.model.dto.dog.DogDto;
import ru.kuranov.dogwalk.model.mapper.interfaces.DogDtoMapper;
import ru.kuranov.dogwalk.model.service.interfaces.DogService;
import ru.kuranov.dogwalk.model.service.interfaces.OwnerService;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/profile/owner/registration/dog")
public class DogRegistrationController {

    private final DogService dogService;
    private final DogDtoMapper dogDtoMapper;
    private final DogDtoValidator dogDtoValidator;

    @GetMapping
    public String registrationDog(DogDto dogDto, Model model) {
        dogDto = dogDtoMapper.getDogDto();
        System.out.println();
        model.addAttribute("dogDto", dogDto);
        return "registration-dog";
    }

    @PostMapping
    public String registrationDog(@Valid DogDto dogDto,
                                  BindingResult bindingResult,
                                  Model model,
                                  Principal principal) {

        if (!dogDtoValidator.validDate(dogDto.getWalkDate())) {
            model.addAttribute("dateValidationError", "ВЫ ДОЛЖНЫ ВЫБРАТЬ ДАТУ, НАЧИНАЯ С ЗАВТРАШНЕГО ДНЯ");
        }
        if (dogDto.getWalkBegin() == null) {
            model.addAttribute("timeValidationError", "НЕ ВЫБРАНО ВРЕМЯ ПРОГУЛКИ");
        }
        if (bindingResult.hasErrors()) {
            dogDto.setCities(dogDtoMapper.getCities());
            return "registration-dog";
        }

        //TODO сохраняем DTO
        System.out.println();

        dogService.saveDog(dogDto, principal.getName());
        return "redirect:/owner/profile";
    }
}
