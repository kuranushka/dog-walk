package ru.kuranov.dogwalk.model.service.interfaces;

import org.springframework.stereotype.Service;
import ru.kuranov.dogwalk.model.entity.location.City;

import java.util.List;

@Service
public interface CityService {

    City findByName(String name);

    List<City> findAll();
    //TODO разобраться с интерфейсами
}
