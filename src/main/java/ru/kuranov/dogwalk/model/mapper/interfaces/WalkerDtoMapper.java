package ru.kuranov.dogwalk.model.mapper.interfaces;

import org.springframework.stereotype.Service;
import ru.kuranov.dogwalk.model.dto.walker.WalkerDto;
import ru.kuranov.dogwalk.model.entity.main.Walker;

@Service
public interface WalkerDtoMapper {

    Walker getWalker(WalkerDto walkerDto);

    WalkerDto getWalkerDto(Walker walker);
}

