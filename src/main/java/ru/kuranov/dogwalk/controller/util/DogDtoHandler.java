package ru.kuranov.dogwalk.controller.util;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kuranov.dogwalk.model.dto.dog.DogDto;
import ru.kuranov.dogwalk.model.entity.addition.*;
import ru.kuranov.dogwalk.model.service.interfaces.CityService;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DogDtoHandler {

    private final CityService cityService;

    public DogDto updateDogDto(DogDto dogDto) throws
            NoSuchFieldException, IllegalAccessException {

        dogDto.setDogDocuments(
                updateProperties(dogDto.getDogDocuments()));
        dogDto.setAggression(
                updateProperties(dogDto.getAggression()));
        dogDto.setCities(cityService.findAll());

        dogDto.setGender(updateProperties(Gender.class, dogDto.getReturnedGender()));
        dogDto.setPullingLeash(updateProperties(PullingLeash.class, dogDto.getReturnedPullingLeash()));
        dogDto.setPickUpFromGround(updateProperties(PickUpFromGround.class, dogDto.getReturnedPickUpFromGround()));
        dogDto.setPickItUp(updateProperties(PickItUp.class, dogDto.getReturnedPickItUp()));
        dogDto.setGoWithoutLeash(updateProperties(GoWithoutLeash.class, dogDto.getReturnedGoWithoutLeash()));
        dogDto.setInteractWithOtherDogs(updateProperties(InteractWithOtherDogs.class, dogDto.getReturnedInteractWithOtherDogs()));
        dogDto.setWashPaws(updateProperties(WashPaws.class, dogDto.getReturnedWashPaws()));
        dogDto.setMeetingToWalker(updateProperties(MeetingToWalker.class, dogDto.getReturnedMeetingToWalker()));
        dogDto.setHowGetKeys(updateProperties(HowGetKeys.class, dogDto.getReturnedHowGetKeys()));

        return dogDto;
    }

    private Map<String, Boolean> updateProperties(Map<String, Boolean> properties) {
        return properties.entrySet().stream().map(entry -> {
            if (entry.getValue() == null) {
                entry.setValue(false);
            } else {
                entry.setValue(entry.getValue());
            }
            return entry;
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private Map<String, Boolean> updateProperties(Class<? extends Enum> type, String property)
            throws NoSuchFieldException, IllegalAccessException {

        Object[] values = type.getEnumConstants();
        Field field = type.getDeclaredField("name");
        field.setAccessible(true);
        Map<String, Boolean> properties = new HashMap<>();
        for (Object obj : values) {
            if (field.get(obj).toString().equals(property)) {
                properties.put(field.get(obj).toString(), true);
            } else {
                properties.put(field.get(obj).toString(), false);
            }
        }
        return properties;
    }

    public boolean validDate(String walkDate) {
        LocalDate date = LocalDate.parse(walkDate);
        return date.isBefore(ChronoLocalDate.from(date));
    }
}