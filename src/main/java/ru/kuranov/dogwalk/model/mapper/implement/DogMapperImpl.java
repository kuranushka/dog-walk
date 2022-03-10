package ru.kuranov.dogwalk.model.mapper.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import ru.kuranov.dogwalk.model.dto.dog.DogDto;
import ru.kuranov.dogwalk.model.entity.dog.Dog;
import ru.kuranov.dogwalk.model.entity.dog.Vet;
import ru.kuranov.dogwalk.model.entity.dog.WeightGroup;
import ru.kuranov.dogwalk.model.entity.location.City;
import ru.kuranov.dogwalk.model.entity.location.District;
import ru.kuranov.dogwalk.model.entity.location.Metro;
import ru.kuranov.dogwalk.model.entity.location.WalkingPlace;
import ru.kuranov.dogwalk.model.entity.owner.Owner;
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

    @Value("${dog.weight.light.max}")
    private int lightWeight;

    @Value("${dog.weight.middle.max}")
    private int middleWeight;

    private final OwnerService ownerService;

    @Override
    public Dog getDog(DogDto dogDto) {

        return Dog.builder()
                .id(dogDto.getId())
                .owner(getOwner(dogDto.getOwnerName()))
                .name(dogDto.getName())
                .breed(dogDto.getBreed())
                .birthday(dogDto.getBirthday())
                .gender(dogDto.getGender())
                .weight(dogDto.getWeight())
                .weightGroup(getWeightGroup(dogDto))
                .dogDocuments(dogDto.getDogDocuments())
                .vet(getVet(dogDto.getVetAddress(), dogDto.getVetPhone()))
                .injury(dogDto.getInjury())
                .pullingLeash(dogDto.getPullingLeash())
                .pickUpFromGround(dogDto.getPickUpFromGround())
                .pickItUp(dogDto.getPickItUp())
                .fear(dogDto.getFear())
                .aggression(dogDto.getAggression())
                .isGoWithoutLeash(dogDto.isGoWithoutLeash())
                .isInteractWithOtherDogs(dogDto.isInteractWithOtherDogs())
                .isWashPaws(dogDto.isWashPaws())
                .washPaws(dogDto.getWashPaws())
                .isFeedAfterWalk(dogDto.isFeedAfterWalk())
                .feed(dogDto.getFeed())
                .portion(dogDto.getPortion())
                .walkingPeriod(dogDto.getWalkingPeriod())
                .schedule(
                        getSchedule(dogDto.getWalkDate(),
                                dogDto.getWalkBegin(),
                                dogDto.getWalkingPeriod()))
                .meetingToWalker(dogDto.getMeetingToWalker())
                .howGetPet(dogDto.getHowGetPet())
                .additionInfo(dogDto.getAdditionInfo())
                .walkingPlace(Collections
                        .singleton(
                                getWalkingPlace(
                                        dogDto.getCityName(),
                                        dogDto.isMetro(),
                                        dogDto.getLocation())))
                .build();
    }

    @Override
    public DogDto getDogDto(Dog dog) {
        return null;
    }

    private Vet getVet(String vetAddress, String vetPhone) {
        return Vet.builder()
                .address(vetAddress)
                .phone(vetPhone)
                .build();
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

    private WalkingPlace getWalkingPlace(String cityName, boolean isMetro, String location) {
        City city = City.builder()
                .cityName(cityName)
                .build();

        WalkingPlace walkingPlace = WalkingPlace.builder()
                .city(city)
                .build();

        if (isMetro) {
            Metro metro = Metro.builder()
                    .metroName(location)
                    .build();
            walkingPlace.setMetro(metro);
        } else {
            District district = District.builder()
                    .districtName(location)
                    .build();
            walkingPlace.setDistrict(district);
        }
        return walkingPlace;
    }

    private Owner getOwner(String ownerName) {
        return ownerService.findByName(ownerName);
    }
}