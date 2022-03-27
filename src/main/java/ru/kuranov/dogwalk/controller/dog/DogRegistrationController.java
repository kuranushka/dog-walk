package ru.kuranov.dogwalk.controller.dog;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kuranov.dogwalk.model.dto.dog.DogDto;
import ru.kuranov.dogwalk.service.DogService;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/profile/owner/registration/dog")
public class DogRegistrationController {
    private final DogService dogService;

    @GetMapping
    public String registrationDog(DogDto dogDto, Model model) {
        dogDto = dogService.getDogDto();
        System.out.println();
        model.addAttribute("dogDto", dogDto);
        return "registration-dog";
    }

    @PostMapping
    public String registrationDog(@Valid DogDto dogDto,
                                  BindingResult bindingResult,
                                  Model model,
                                  Principal principal) {

        if (!dogService.validDate(dogDto.getWalkingDate())) {
            model.addAttribute("dateValidationError",
                    "ВЫ ДОЛЖНЫ ВЫБРАТЬ ДАТУ, НАЧИНАЯ С ЗАВТРАШНЕГО ДНЯ");
        }
        if (dogDto.getWalkingBegin() == null) {
            model.addAttribute("timeValidationError",
                    "НЕ ВЫБРАНО ВРЕМЯ ПРОГУЛКИ");
        }
        if (bindingResult.hasErrors()) {
            dogDto.setCities(dogService.getCities());
            return "registration-dog";
        }
        dogService.saveNewDog(dogDto, principal.getName());
        return "redirect:/owner/profile";
    }
}
