package ru.kuranov.dogwalk.model.mapper.interfaces;

import org.springframework.stereotype.Service;
import ru.kuranov.dogwalk.model.dto.dog.DogDto;
import ru.kuranov.dogwalk.model.entity.location.City;
import ru.kuranov.dogwalk.model.entity.main.Dog;
import ru.kuranov.dogwalk.model.entity.main.Owner;

import java.util.List;

@Service
public interface DogDtoMapper {

    Dog getDog(DogDto dogDto, String ownerName);

    DogDto getDogDto();

    List<City> getCities();
}
