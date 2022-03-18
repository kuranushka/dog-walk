package ru.kuranov.dogwalk.model.mapper.interfaces;

import org.springframework.stereotype.Service;
import ru.kuranov.dogwalk.model.dto.dog.DogDto;
import ru.kuranov.dogwalk.model.entity.main.Dog;
import ru.kuranov.dogwalk.model.entity.main.Owner;

@Service
public interface DogDtoMapper {

    Dog getDog(DogDto dogDto, Owner owner) throws NoSuchFieldException;

    DogDto getDogDto() throws NoSuchFieldException;
}
