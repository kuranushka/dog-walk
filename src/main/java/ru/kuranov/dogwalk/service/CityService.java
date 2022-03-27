package ru.kuranov.dogwalk.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kuranov.dogwalk.exceptions.NoSuchCityException;
import ru.kuranov.dogwalk.model.entity.location.City;
import ru.kuranov.dogwalk.repository.location.CityRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;

    public City findByName(String name) {
        Optional<City> cityOptional = cityRepository.findByName(name);
        return cityOptional.orElseThrow(() -> new NoSuchCityException(name));
    }

    public List<City> findAll() {
        return cityRepository.findAll();
    }
}
