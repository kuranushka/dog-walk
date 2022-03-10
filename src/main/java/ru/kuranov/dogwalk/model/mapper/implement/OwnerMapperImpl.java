package ru.kuranov.dogwalk.model.mapper.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kuranov.dogwalk.model.dto.owner.OwnerDto;
import ru.kuranov.dogwalk.model.entity.owner.Owner;
import ru.kuranov.dogwalk.model.mapper.interfaces.OwnerMapper;

@Service
@RequiredArgsConstructor
public class OwnerMapperImpl implements OwnerMapper {
    @Override
    public Owner getOwner(OwnerDto ownerDto) {
        return null;
    }

    @Override
    public OwnerDto getOwnerDto(Owner owner) {
        return null;
    }
}
