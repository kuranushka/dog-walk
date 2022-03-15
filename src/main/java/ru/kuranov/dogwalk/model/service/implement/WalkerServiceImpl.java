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

//    @Override
//    public Walker findByName(String walkerName) {
//        Optional<Walker> walkerOptional = walkerRepository.findByName(walkerName);
//        return walkerOptional.orElseThrow(() -> new NoSuchWalkerException(walkerName));
//    }

    @Override
    @Transactional
    public void save(Walker walker) {
        walkerRepository.save(walker);
    }

//    @Override
//    public boolean isThereSuchLogin(String username) {
//        return walkerRepository.isThereSuchUsername(username);
//    }

//    @Override
//    public Optional<Walker> findByUsername(String username) {
//        return walkerRepository.findByUsername(username);
//    }
}
