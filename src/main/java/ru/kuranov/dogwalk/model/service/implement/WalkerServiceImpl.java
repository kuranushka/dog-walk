package ru.kuranov.dogwalk.model.service.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kuranov.dogwalk.exceptions.NoSuchWalkerException;
import ru.kuranov.dogwalk.model.entity.walker.Walker;
import ru.kuranov.dogwalk.model.repository.walker.WalkerRepository;
import ru.kuranov.dogwalk.model.service.interfaces.WalkerService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WalkerServiceImpl implements WalkerService {

    private final WalkerRepository walkerRepository;

    @Override
    public Walker findByName(String walkerName) {
        Optional<Walker> walkerOptional = walkerRepository.findByName(walkerName);
        return walkerOptional.orElseThrow(() -> new NoSuchWalkerException(walkerName));
    }

    @Override
    public void save(Walker walker) {
        walkerRepository.save(walker);
    }

    @Override
    public boolean isThereSuchLogin(String username) {
        return walkerRepository.isThereSuchUsername(username);
    }
}
