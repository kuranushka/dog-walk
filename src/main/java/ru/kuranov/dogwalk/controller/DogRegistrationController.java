package ru.kuranov.dogwalk.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kuranov.dogwalk.controller.util.DogDtoHandler;
import ru.kuranov.dogwalk.model.dto.dog.DogDto;
import ru.kuranov.dogwalk.model.entity.addition.Aggression;
import ru.kuranov.dogwalk.model.mapper.interfaces.DogDtoMapper;
import ru.kuranov.dogwalk.model.service.interfaces.DogService;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/profile/owner/registration/dog")
public class DogRegistrationController {

    private final DogService dogService;
    private final DogDtoMapper dogDtoMapper;
    private final DogDtoHandler dogDtoHandler;

    @GetMapping
    public String registrationDog(DogDto dogDto, Model model) throws NoSuchFieldException {
        dogDto = dogDtoMapper.getDogDto();
        model.addAttribute("dogDto", dogDto);
        return "registration-dog";
    }

    @PostMapping
    public String registrationDog(@Valid DogDto dogDto,
                                  BindingResult bindingResult,
                                  Model model)
            throws NoSuchFieldException, IllegalAccessException {

        if (bindingResult.hasErrors()) {
            model.addAttribute("dogDto", dogDtoHandler.updateDogDto(dogDto));
            return "registration-dog";
        }
        //TODO добавить Owner и дописать
//        Dog dog = dogMapper.getDog(dogDto, );
//        dogService.save(dog);
        return "redirect:/owner/profile";
    }

    private List<Aggression> getAggression() {
        Aggression[] values = Aggression.values();
        return Arrays.stream(values).collect(Collectors.toList());
    }
}
