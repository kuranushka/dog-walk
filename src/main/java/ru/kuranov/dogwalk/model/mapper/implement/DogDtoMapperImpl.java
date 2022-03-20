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
import ru.kuranov.dogwalk.model.entity.time.Schedule;
import ru.kuranov.dogwalk.model.entity.time.WalkTime;
import ru.kuranov.dogwalk.model.mapper.interfaces.DogDtoMapper;
import ru.kuranov.dogwalk.model.service.interfaces.CityService;
import ru.kuranov.dogwalk.model.service.interfaces.OwnerService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

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
    public Dog getDog(DogDto dogDto, String ownerName) {

        return Dog.builder()
                .id(dogDto.getId())
                .name(dogDto.getName())
                .breed(dogDto.getBreed())
                .age(dogDto.getAge())
                .gender(dogDto.getGender())
                .weight(dogDto.getWeight())
                .weightGroup(getWeightGroup(dogDto.getWeight()))
                .dogDocuments(dogDto.getDogDocuments())
                .vet(dogDto.getVet())
                .injury(dogDto.getInjury())
                .pullingLeash(dogDto.getPullingLeash())
                .pickUpFromGround(dogDto.getPickUpFromGround())
                .pickItUp(dogDto.getPickItUp())
                .fear(dogDto.getFear())
                .aggression(dogDto.getAggression())
                .goWithoutLeash(dogDto.getGoWithoutLeash())
                .interactWithOtherDogs(dogDto.getInteractWithOtherDogs())
                .washPaws(dogDto.getWashPaws())
                .feedAfterWalk(dogDto.getFeedAfterWalk())
                .walkingPeriod(dogDto.getWalkingPeriod())
                .schedule(getSchedule(
                        parseDate(dogDto.getWalkDate()),
                        dogDto.getWalkBegin(),
                        dogDto.getWalkingPeriod()))
                .meetingToWalker(dogDto.getMeetingToWalker())
                .howGetKeys(dogDto.getHowGetKeys())
                .additionInfo(dogDto.getAdditionInfo())
                .walkingPlace(Collections.singleton(
                        getWalkingPlace(
                                dogDto.getCity(),
                                dogDto.getLocation(),
                                dogDto.getAddress())))
                .build();
    }

    @Override
    public DogDto getDogDto() {
        return DogDto.builder()
                .cities(getCities())
                .build();
    }

    private LocalDate parseDate(String walkDate) {
        return LocalDate.parse(walkDate);
    }

    public List<City> getCities() {
        return citiService.findAll();
    }

    private WeightGroup getWeightGroup(int weight) {
        WeightGroup weightGroup;
        if (weight < lightWeight) {
            weightGroup = WeightGroup.LIGHT_WEIGHT;
        } else if (weight > middleWeight) {
            weightGroup = WeightGroup.HEAVY_WEIGHT;
        } else {
            weightGroup = WeightGroup.MIDDLE_WEIGHT;
        }
        return weightGroup;
    }

    private Schedule getSchedule(
            LocalDate walkDate,
            LocalTime walkBegin,
            int walkingPeriod) {

        WalkTime walkTime = WalkTime.builder()
                .walkBegin(walkBegin)
                .walkEnd(walkBegin.plusMinutes(walkingPeriod))
                .walkDate(walkDate)
                .build();
        return Schedule.builder()
                .walkTimeList(Collections.singleton(walkTime))
                .build();
    }

    private WalkingPlace getWalkingPlace(
            String cityName,
            String location,
            String address) {
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