package ru.kuranov.dogwalk.model.service.interfaces;

import org.springframework.stereotype.Service;
import ru.kuranov.dogwalk.model.entity.dog.Dog;

@Service
public interface DogService {

    void save(Dog dog);
}
