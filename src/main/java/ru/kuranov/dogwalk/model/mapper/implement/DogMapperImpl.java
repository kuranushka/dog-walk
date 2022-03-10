package ru.kuranov.dogwalk.model.mapper.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kuranov.dogwalk.model.dto.dog.DogDto;
import ru.kuranov.dogwalk.model.entity.dog.Dog;
import ru.kuranov.dogwalk.model.mapper.interfaces.DogMapper;

@Service
@RequiredArgsConstructor
public class DogMapperImpl implements DogMapper {

    @Override
    public Dog getDog(DogDto dogDto) {
        return null;
    }

    @Override
    public DogDto getDogDto(Dog dog) {
        return null;
    }
}