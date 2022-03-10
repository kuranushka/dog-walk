package ru.kuranov.dogwalk.model.mapper.interfaces;

import org.springframework.stereotype.Service;
import ru.kuranov.dogwalk.model.dto.owner.OwnerDto;
import ru.kuranov.dogwalk.model.entity.owner.Owner;

@Service
public interface OwnerMapper {

    Owner getOwner(OwnerDto ownerDto);

    OwnerDto getOwnerDto(Owner owner);
}
