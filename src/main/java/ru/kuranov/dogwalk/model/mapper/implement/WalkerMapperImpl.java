package ru.kuranov.dogwalk.model.mapper.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kuranov.dogwalk.model.dto.walker.WalkerDto;
import ru.kuranov.dogwalk.model.entity.location.Citizenship;
import ru.kuranov.dogwalk.model.entity.location.City;
import ru.kuranov.dogwalk.model.entity.walker.Walker;
import ru.kuranov.dogwalk.model.mapper.interfaces.WalkerMapper;
import ru.kuranov.dogwalk.model.service.interfaces.CitizenshipService;
import ru.kuranov.dogwalk.model.service.interfaces.CityService;

@Service
@RequiredArgsConstructor
public class WalkerMapperImpl implements WalkerMapper {

    private final CityService cityService;
    private final CitizenshipService citizenshipService;

    @Override
    public Walker getWalker(WalkerDto walkerDto) {
        return Walker.builder()
                .id(walkerDto.getId())
                .username(walkerDto.getUsername())
                .password(walkerDto.getPassword())
                .name(walkerDto.getName())
                .surname(walkerDto.getSurname())
                .mail(walkerDto.getMail())
                .phone(walkerDto.getPhone())
                .birthday(walkerDto.getBirthday())
                .city(getCity(walkerDto.getCity()))
                .socialLinks(walkerDto.getSocialLinks())
                .citizenship(getCitizenShip(walkerDto.getCitizenship()))
                .build();

    }

    private Citizenship getCitizenShip(String citizenship) {
        return citizenshipService.findByName(citizenship);
    }

    private City getCity(String name) {
        return cityService.findByName(name);
    }

    @Override
    public WalkerDto getWalkerDto(Walker walker) {
        return null;
    }
}
