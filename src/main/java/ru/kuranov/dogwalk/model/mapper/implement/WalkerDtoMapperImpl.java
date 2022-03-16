package ru.kuranov.dogwalk.model.mapper.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kuranov.dogwalk.model.dto.walker.WalkerDto;
import ru.kuranov.dogwalk.model.entity.location.City;
import ru.kuranov.dogwalk.model.entity.main.Walker;
import ru.kuranov.dogwalk.model.mapper.interfaces.WalkerDtoMapper;
import ru.kuranov.dogwalk.model.service.interfaces.CityService;
import ru.kuranov.dogwalk.model.service.interfaces.RoleService;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class WalkerDtoMapperImpl implements WalkerDtoMapper {

    private final CityService cityService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Walker getWalker(WalkerDto walkerDto) {
        return Walker.builder()
                .id(walkerDto.getId())
                .username(walkerDto.getUsername())
                .password(passwordEncoder.encode(walkerDto.getPassword()))
                .roles(Collections.singleton(roleService.findByRole("WALKER")))
                .name(walkerDto.getName())
                .surname(walkerDto.getSurname())
                .mail(walkerDto.getMail())
                .phone(walkerDto.getPhone())
                .birthday(walkerDto.getBirthday())
                .city(getCity(walkerDto.getCity()))
                .socialLinks(walkerDto.getSocialLinks())
                .citizenship(walkerDto.getCitizenship())
                .build();

    }

    private City getCity(String name) {
        return cityService.findByName(name);
    }

    @Override
    public WalkerDto getWalkerDto(Walker walker) {
        return null;
    }
}
