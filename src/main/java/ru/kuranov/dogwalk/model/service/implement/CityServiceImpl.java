package ru.kuranov.dogwalk.model.service.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kuranov.dogwalk.exceptions.NoSuchCityException;
import ru.kuranov.dogwalk.model.entity.location.City;
import ru.kuranov.dogwalk.model.repository.location.CityRepository;
import ru.kuranov.dogwalk.model.service.interfaces.CityService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Override
    public City findByName(String name) {
        Optional<City> cityOptional = cityRepository.findByName(name);
        return cityOptional.orElseThrow(() -> new NoSuchCityException(name));
    }

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }
}
