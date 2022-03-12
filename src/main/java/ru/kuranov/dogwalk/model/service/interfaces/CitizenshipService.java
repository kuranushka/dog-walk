package ru.kuranov.dogwalk.model.service.interfaces;

import org.springframework.stereotype.Service;
import ru.kuranov.dogwalk.model.entity.location.Citizenship;

import java.util.List;

@Service
public interface CitizenshipService {

    Citizenship findByName(String name);

    List<Citizenship> findAll();
}
