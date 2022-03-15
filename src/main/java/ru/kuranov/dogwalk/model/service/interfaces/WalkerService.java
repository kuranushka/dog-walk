package ru.kuranov.dogwalk.model.service.interfaces;

import org.springframework.stereotype.Service;
import ru.kuranov.dogwalk.model.entity.walker.Walker;

@Service
public interface WalkerService {

    void save(Walker walker);
}
