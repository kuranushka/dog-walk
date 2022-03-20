package ru.kuranov.dogwalk.model.service.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kuranov.dogwalk.model.dto.dog.DogDto;
import ru.kuranov.dogwalk.model.entity.main.Dog;
import ru.kuranov.dogwalk.model.mapper.interfaces.DogDtoMapper;
import ru.kuranov.dogwalk.model.repository.main.DogRepository;
import ru.kuranov.dogwalk.model.service.interfaces.DogService;

@Service
@RequiredArgsConstructor
public class DogServiceImpl implements DogService {
    private final DogDtoMapper dogDtoMapper;

    private final DogRepository dogRepository;

    @Override
    public void save(Dog dog) {
        dogRepository.save(dog);
    }

    @Override
    public void saveDog(DogDto dogDto, String ownerName) {
        Dog dog = dogDtoMapper.getDog(dogDto, ownerName);
        save(dog);
    }
}
