package ru.kuranov.dogwalk.model.service.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kuranov.dogwalk.model.entity.walker.Walker;
import ru.kuranov.dogwalk.model.repository.walker.WalkerRepository;
import ru.kuranov.dogwalk.model.service.interfaces.WalkerService;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class WalkerServiceImpl implements WalkerService {

    private final WalkerRepository walkerRepository;

    @Override
    @Transactional
    public void save(Walker walker) {
        walkerRepository.save(walker);
    }
}
