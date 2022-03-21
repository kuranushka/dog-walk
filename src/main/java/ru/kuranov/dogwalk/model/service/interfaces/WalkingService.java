package ru.kuranov.dogwalk.model.service.interfaces;

import org.springframework.stereotype.Service;
import ru.kuranov.dogwalk.model.entity.main.Walking;

@Service
public interface WalkingService {

    void save(Walking walking);
}
