package ru.kuranov.dogwalk.model.mapper.implement;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;
import ru.kuranov.dogwalk.model.dto.dog.DogDto;
import ru.kuranov.dogwalk.model.entity.dog.Dog;
import ru.kuranov.dogwalk.model.mapper.interfaces.DogMapper;

@Service
@RequiredArgsConstructor

public class DogMapperImpl implements DogMapper {

    @Value("${dog.weight.light.max}")
    private int lightWeight;

    @Override
    public Dog getDog(DogDto dogDto) {


        Dog dog = Dog.builder()
                .id(dogDto.getId())
                .name(dogDto.getName())
                .breed(dogDto.getBreed())
                .birthday(dogDto.getBirthday())
                .gender(dogDto.getGender())
                .weight(dogDto.getWeight())
                .build();
        return  dog;
    }

    @Override
    public DogDto getDogDto(Dog dog) {
        return null;
    }
}