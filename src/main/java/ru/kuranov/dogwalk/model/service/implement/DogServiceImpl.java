package ru.kuranov.dogwalk.model.service.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kuranov.dogwalk.model.entity.dog.Dog;
import ru.kuranov.dogwalk.model.repository.dog.DogRepository;
import ru.kuranov.dogwalk.model.service.interfaces.DogService;

@Service
@RequiredArgsConstructor
public class DogServiceImpl implements DogService {

    private final DogRepository dogRepository;

    @Override
    public void save(Dog dog) {
        dogRepository.save(dog);
    }
}
