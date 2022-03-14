package ru.kuranov.dogwalk.model.mapper.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kuranov.dogwalk.model.dto.owner.OwnerDto;
import ru.kuranov.dogwalk.model.entity.owner.Owner;
import ru.kuranov.dogwalk.model.mapper.interfaces.OwnerMapper;
import ru.kuranov.dogwalk.model.service.interfaces.RoleService;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class OwnerMapperImpl implements OwnerMapper {

    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    @Override
    public Owner getOwner(OwnerDto ownerDto) {
        return Owner.builder()
                .id(ownerDto.getId())
                .username(ownerDto.getUsername())
                .password(passwordEncoder.encode(ownerDto.getPassword()))
                .roles(Collections.singleton(roleService.findByRole("OWNER")))
                .name(ownerDto.getName())
                .surname(ownerDto.getSurname())
                .mail(ownerDto.getMail())
                .phone(ownerDto.getPhone())
                .build();
    }

    @Override
    public OwnerDto getOwnerDto(Owner owner) {
        return OwnerDto.builder()
                .id(owner.getId())
                .username(owner.getUsername())
                .password(owner.getPassword())
                .name(owner.getName())
                .surname(owner.getSurname())
                .mail(owner.getMail())
                .phone(owner.getPhone())
                .build();
    }
}
