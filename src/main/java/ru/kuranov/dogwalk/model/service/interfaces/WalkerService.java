package ru.kuranov.dogwalk.model.service.interfaces;

import org.springframework.stereotype.Service;
import ru.kuranov.dogwalk.model.dto.walker.WalkerDto;
import ru.kuranov.dogwalk.model.entity.main.Walker;

@Service
public interface WalkerService {

    void save(Walker walker);

    WalkerDto getWalkerDto();

}
