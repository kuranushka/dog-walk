package ru.kuranov.dogwalk.model.service.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kuranov.dogwalk.model.entity.main.Walking;
import ru.kuranov.dogwalk.model.repository.main.WalkingRepository;
import ru.kuranov.dogwalk.model.service.interfaces.WalkingService;

@Service
@RequiredArgsConstructor
public class WalkingServiceImpl implements WalkingService {
    private final WalkingRepository walkingRepository;

    @Override
    public void save(Walking walking) {
        walkingRepository.save(walking);
    }
}
