package ru.kuranov.dogwalk.model.mapper.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import ru.kuranov.dogwalk.model.dto.dog.DogDto;
import ru.kuranov.dogwalk.model.entity.addition.WeightGroup;
import ru.kuranov.dogwalk.model.entity.location.City;
import ru.kuranov.dogwalk.model.entity.location.WalkingPlace;
import ru.kuranov.dogwalk.model.entity.main.Dog;
import ru.kuranov.dogwalk.model.entity.main.Owner;
import ru.kuranov.dogwalk.model.entity.time.Schedule;
import ru.kuranov.dogwalk.model.entity.time.WalkTime;
import ru.kuranov.dogwalk.model.mapper.interfaces.DogMapper;
import ru.kuranov.dogwalk.model.service.interfaces.OwnerService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;

@Service
@RequiredArgsConstructor
@PropertySource("classpath:app-values.properties")
public class DogMapperImpl implements DogMapper {

    private final OwnerService ownerService;
    @Value("${dog.weight.light.max}")
    private int lightWeight;
    @Value("${dog.weight.middle.max}")
    private int middleWeight;

    @Override
    public Dog getDog(DogDto dogDto, Owner owner) {

        return Dog.builder()
                .id(dogDto.getId())
                .owner(owner)
                .name(dogDto.getName())
                .breed(dogDto.getBreed())
                .age(dogDto.getAge())
                .gender(dogDto.getGender())
                .weight(dogDto.getWeight())
                .weightGroup(getWeightGroup(dogDto))
                .dogDocuments(dogDto.getDogDocuments())
                .vet(dogDto.getVet())
                .injury(dogDto.getInjury())
                .pullingLeash(dogDto.getPullingLeash())
                .pickUpFromGround(dogDto.getPickUpFromGround())
                .pickItUp(dogDto.getPickItUp())
                .fear(dogDto.getFear())
                .aggression(dogDto.getAggression())
                .isGoWithoutLeash(dogDto.isGoWithoutLeash())
                .isInteractWithOtherDogs(dogDto.isInteractWithOtherDogs())
                .washPaws(dogDto.getWashPaws())
                .isFeedAfterWalk(dogDto.isFeedAfterWalk())
                .feed(dogDto.getFeed())
                .walkingPeriod(dogDto.getWalkingPeriod())
                .schedule(
                        getSchedule(dogDto.getWalkDate(),
                                dogDto.getWalkBegin(),
                                dogDto.getWalkingPeriod()))
                .meetingToWalker(dogDto.getMeetingToWalker())
                .howGetKeys(dogDto.getHowGetKeys())
                .additionInfo(dogDto.getAdditionInfo())
                .walkingPlace(Collections
                        .singleton(
                                getWalkingPlace(
                                        dogDto.getCityName(),
                                        dogDto.getLocation(),
                                        dogDto.getAddress())))
                .build();
    }

    @Override
    public DogDto getDogDto(Dog dog) {
        return null;
    }


    private WeightGroup getWeightGroup(DogDto dogDto) {
        WeightGroup weightGroup;
        if (dogDto.getWeight() < lightWeight) {
            weightGroup = WeightGroup.LIGHT_WEIGHT;
        } else if (dogDto.getWeight() > middleWeight) {
            weightGroup = WeightGroup.HEAVY_WEIGHT;
        } else {
            weightGroup = WeightGroup.MIDDLE_WEIGHT;
        }
        return weightGroup;
    }

    private Schedule getSchedule(LocalDate walkDate, LocalTime walkBegin, int walkingPeriod) {
        WalkTime walkTime = WalkTime.builder()
                .walkBegin(walkBegin)
                .walkEnd(walkBegin.plusMinutes(walkingPeriod))
                .walkDate(walkDate)
                .build();
        return Schedule.builder()
                .walkTimeList(Collections.singleton(walkTime))
                .build();
    }

    private WalkingPlace getWalkingPlace(String cityName, String location, String address) {
        City city = City.builder()
                .name(cityName)
                .build();

        return WalkingPlace.builder()
                .city(city)
                .location(location)
                .address(address)
                .build();
    }
}