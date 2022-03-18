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

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
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
                .gender(getPropertySingle(Gender.class, dogDto.getGender()))
                .weightGroup(getWeightGroup(dogDto.getWeight()))



//                .weight(dogDto.getWeight())
//                .weightGroup(getWeightGroup(dogDto))
//                .dogDocuments(dogDto.getDogDocuments())
//                .vet(dogDto.getVet())
//                .injury(dogDto.getInjury())
//                .pullingLeash(dogDto.getPullingLeash())
//                .pickUpFromGround(dogDto.getPickUpFromGround())
//                .pickItUp(dogDto.getPickItUp())
//                .fear(dogDto.getFear())
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
    public DogDto getDogDto() throws NoSuchFieldException {
        return DogDto.builder()
                .gender(getProperties(Gender.class))
                .dogDocuments(getProperties(DogDocument.class))
                .pullingLeash(getProperties(PullingLeash.class))
                .pickUpFromGround(getProperties(PickUpFromGround.class))
                .pickItUp(getProperties(PickItUp.class))
                .aggression(getProperties(Aggression.class))
                .goWithoutLeash(getProperties(GoWithoutLeash.class))
                .interactWithOtherDogs(getProperties(InteractWithOtherDogs.class))
                .washPaws(getProperties(WashPaws.class))
                .meetingToWalker(getProperties(MeetingToWalker.class))
                .howGetKeys(getProperties(HowGetKeys.class))
                .cities(getCities())
                .build();

    }


    private List<City> getCities() {
        return citiService.findAll();
    }


    private <T extends Enum<T>> T getPropertySingle(Class<T> type, Map<String, Boolean> properties) {
        String enumValue = properties.entrySet().stream()
                .filter(entry -> entry.getValue())
                .map(Map.Entry::getKey)
                .findFirst()
                .get();
        return Enum.valueOf(type, enumValue);
    }

    private Map<String, Boolean> getProperties(Class<? extends Enum> type) throws NoSuchFieldException {
        Object[] values = type.getEnumConstants();
        Field field = type.getDeclaredField("name");
        field.setAccessible(true);
        return Arrays.stream(values)
                .map(value -> {
                    try {
                        return field.get(value);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    return value;
                })
                .collect(Collectors.toMap(Object::toString, val -> false));
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