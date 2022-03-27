package ru.kuranov.dogwalk.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kuranov.dogwalk.model.entity.main.Walking;
import ru.kuranov.dogwalk.repository.main.WalkingRepository;

@Service
@RequiredArgsConstructor
public class WalkingService {
    private final WalkingRepository walkingRepository;

    public void save(Walking walking) {
        walkingRepository.save(walking);
    }
}
