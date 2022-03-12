package ru.kuranov.dogwalk.model.mapper.interfaces;

import org.springframework.stereotype.Service;
import ru.kuranov.dogwalk.model.dto.walker.WalkerDto;
import ru.kuranov.dogwalk.model.entity.walker.Walker;

@Service
public interface WalkerMapper {

    Walker getWalker(WalkerDto walkerDto);

    WalkerDto getWalkerDto(Walker walker);
}

