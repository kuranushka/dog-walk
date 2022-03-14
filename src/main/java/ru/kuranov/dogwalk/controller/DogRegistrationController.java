package ru.kuranov.dogwalk.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kuranov.dogwalk.model.dto.dog.DogDto;
import ru.kuranov.dogwalk.model.entity.dog.Dog;
import ru.kuranov.dogwalk.model.mapper.interfaces.DogMapper;
import ru.kuranov.dogwalk.model.service.interfaces.DogService;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class DogRegistrationController {

    private final DogService dogService;
    private final DogMapper dogMapper;

    @GetMapping("/registration/dog")
    public String registrationDog(DogDto dogDto, Model model, Principal principal) {
        //TODO переписать
        dogDto = DogDto.builder().build();
        model.addAttribute("dogDto", dogDto);
        return "registration-dog";
    }

    @PostMapping("/registration/dog")
    public String registrationDog(@Valid DogDto dogDto, BindingResult bindingResult,
                                  Model model, Principal principal) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("dogDto", dogDto);
            return "registration-dog";
        }

        Dog dog = dogMapper.getDog(dogDto);
        dogService.save(dog);
        return "redirect:/owner/profile";
    }
}
