package ru.kuranov.dogwalk.model.service.interfaces;

import org.springframework.stereotype.Service;
import ru.kuranov.dogwalk.model.entity.walker.Walker;

@Service
public interface WalkerService {
    Walker findByName(String walkerName);

    void save(Walker walker);

    boolean isThereSuchLogin(String login);
}
