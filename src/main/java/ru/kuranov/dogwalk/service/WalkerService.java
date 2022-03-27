package ru.kuranov.dogwalk.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kuranov.dogwalk.model.dto.walker.WalkerDto;
import ru.kuranov.dogwalk.model.entity.main.Walker;
import ru.kuranov.dogwalk.repository.main.WalkerRepository;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class WalkerService {

    private final WalkerRepository walkerRepository;
    private final CityService cityService;

    @Transactional
    public void save(Walker walker) {
        walkerRepository.save(walker);
    }

    public WalkerDto getWalkerDto() {
        return WalkerDto.builder()
                .cities(cityService.findAll())
                .build();
    }
}
