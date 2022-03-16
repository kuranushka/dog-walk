package ru.kuranov.dogwalk.model.mapper.interfaces;

import org.springframework.stereotype.Service;
import ru.kuranov.dogwalk.model.dto.owner.OwnerDto;
import ru.kuranov.dogwalk.model.entity.main.Owner;

@Service
public interface OwnerDtoMapper {

    Owner getOwner(OwnerDto ownerDto);

    OwnerDto getOwnerDto(Owner owner);
}
