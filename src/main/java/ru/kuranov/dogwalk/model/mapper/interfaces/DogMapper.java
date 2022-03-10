package ru.kuranov.dogwalk.model.mapper.interfaces;

import org.springframework.stereotype.Service;
import ru.kuranov.dogwalk.model.dto.dog.DogDto;
import ru.kuranov.dogwalk.model.entity.dog.Dog;

@Service
public interface DogMapper {

    Dog getDog(DogDto dogDto);

    DogDto getDogDto(Dog dog);
}
