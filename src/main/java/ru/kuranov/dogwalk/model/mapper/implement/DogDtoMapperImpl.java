package ru.kuranov.dogwalk.model.mapper.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import ru.kuranov.dogwalk.model.dto.dog.DogDto;
import ru.kuranov.dogwalk.model.entity.addition.*;
import ru.kuranov.dogwalk.model.entity.location.City;
import ru.kuranov.dogwalk.model.entity.location.WalkingPlace;
import ru.kuranov.dogwalk.model.entity.main.Dog;
import ru.kuranov.dogwalk.model.entity.main.Owner;
import ru.kuranov.dogwalk.model.entity.time.Schedule;
import ru.kuranov.dogwalk.model.entity.time.WalkTime;
import ru.kuranov.dogwalk.model.mapper.interfaces.DogDtoMapper;
import ru.kuranov.dogwalk.model.service.interfaces.CityService;
import ru.kuranov.dogwalk.model.service.interfaces.OwnerService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@PropertySource("classpath:app-values.properties")
public class DogDtoMapperImpl implements DogDtoMapper {

    private final OwnerService ownerService;
    private final CityService citiService;
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
//                .gender(dogDto.getGender())
                .weight(dogDto.getWeight())
                .weightGroup(getWeightGroup(dogDto))
//                .dogDocuments(dogDto.getDogDocuments())
                .vet(dogDto.getVet())
                .injury(dogDto.getInjury())
//                .pullingLeash(dogDto.getPullingLeash())
//                .pickUpFromGround(dogDto.getPickUpFromGround())
//                .pickItUp(dogDto.getPickItUp())
                .fear(dogDto.getFear())
//                .aggression(dogDto.getAggression())
//                .isGoWithoutLeash(dogDto.isGoWithoutLeash())
//                .isInteractWithOtherDogs(dogDto.isInteractWithOtherDogs())
//                .washPaws(dogDto.getWashPaws())
//                .isFeedAfterWalk(dogDto.isFeedAfterWalk())
//                .feed(dogDto.getFeedAfterWalk())
//                .walkingPeriod(dogDto.getWalkingPeriod())
//                .schedule(
//                        getSchedule(dogDto.getWalkDate(),
//                                dogDto.getWalkBegin(),
//                                dogDto.getWalkingPeriod()))
//                .meetingToWalker(dogDto.getMeetingToWalker())
//                .howGetKeys(dogDto.getHowGetKeys())
                .additionInfo(dogDto.getAdditionInfo())
                .walkingPlace(Collections
                        .singleton(
                                getWalkingPlace(
                                        dogDto.getCity(),
                                        dogDto.getLocation(),
                                        dogDto.getAddress())))
                .build();
    }

    @Override
    public DogDto getDogDto() {
        return DogDto.builder()
                .gender(getGender())
                .dogDocuments(getDogDocuments())
                .pullingLeash(getPullingLeash())
                .pickUpFromGround(getPickUpFromGround())
                .pickItUp(getPickItUp())
                .aggression(getAggression())
                .goWithoutLeash(getGoWithoutLeash())
                .interactWithOtherDogs(getInteractWithOtherDogs())
                .washPaws(getWashPaws())
                .meetingToWalker(getMeetingToWalker())
                .howGetKeys(getHowGetKeys())
                .cities(getCities())
                .build();

    }

    private List<InteractWithOtherDogs> getInteractWithOtherDogs() {
        InteractWithOtherDogs[] values = InteractWithOtherDogs.values();
        return Arrays.stream(values).collect(Collectors.toList());
    }

    private List<GoWithoutLeash> getGoWithoutLeash() {
        GoWithoutLeash[] values = GoWithoutLeash.values();
        return Arrays.stream(values).collect(Collectors.toList());
    }

    private List<Gender> getGender() {
        Gender[] values = Gender.values();
        return Arrays.stream(values).collect(Collectors.toList());
    }


    private List<City> getCities() {
        return citiService.findAll();
    }

    private List<HowGetKeys> getHowGetKeys() {
        HowGetKeys[] values = HowGetKeys.values();
        return Arrays.stream(values).collect(Collectors.toList());
    }

    private List<MeetingToWalker> getMeetingToWalker() {
        MeetingToWalker[] values = MeetingToWalker.values();
        return Arrays.stream(values).collect(Collectors.toList());
    }

    private List<WashPaws> getWashPaws() {
        WashPaws[] values = WashPaws.values();
        return Arrays.stream(values).collect(Collectors.toList());
    }

    private List<Aggression> getAggression() {
        Aggression[] values = Aggression.values();
        return Arrays.stream(values).collect(Collectors.toList());
    }

    private List<PickItUp> getPickItUp() {
        PickItUp[] values = PickItUp.values();
        return Arrays.stream(values).collect(Collectors.toList());
    }

    private List<PickUpFromGround> getPickUpFromGround() {
        PickUpFromGround[] values = PickUpFromGround.values();
        return Arrays.stream(values).collect(Collectors.toList());
    }

    private List<PullingLeash> getPullingLeash() {
        PullingLeash[] values = PullingLeash.values();
        return Arrays.stream(values).collect(Collectors.toList());
    }

    private List<DogDocument> getDogDocuments() {
        DogDocument[] values = DogDocument.values();
        return Arrays.stream(values).collect(Collectors.toList());
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