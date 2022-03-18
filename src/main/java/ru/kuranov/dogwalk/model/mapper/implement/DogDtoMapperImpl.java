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
    public Dog getDog(DogDto dogDto, Owner owner) throws NoSuchFieldException {

        return Dog.builder()
                .id(dogDto.getId())
                .owner(owner)
                .name(dogDto.getName())
                .breed(dogDto.getBreed())
                .age(dogDto.getAge())
                .gender(getPropertySingle(
                        Gender.class,
                        getProperties(Gender.class),
                        dogDto.getReturnedGender()))
                .weightGroup(getWeightGroup(dogDto.getWeight()))
                .dogDocuments(getPropertyList(
                        DogDocument.class,
                        dogDto.getDogDocuments()))
                .vet(dogDto.getVet())
                .injury(dogDto.getInjury())
                .pullingLeash(getPropertySingle(
                        PullingLeash.class,
                        getProperties(PullingLeash.class),
                        dogDto.getReturnedPullingLeash()))
                .pickUpFromGround(getPropertySingle(
                        PickUpFromGround.class,
                        getProperties(PickUpFromGround.class),
                        dogDto.getReturnedPickUpFromGround()))
                .pickItUp(getPropertySingle(
                        PickItUp.class,
                        getProperties(PickItUp.class),
                        dogDto.getReturnedPickItUp()))
                .fear(dogDto.getFear())
                .aggression(getPropertyList(
                        Aggression.class,
                        dogDto.getAggression()))
                .goWithoutLeash(getPropertySingle(
                        GoWithoutLeash.class,
                        getProperties(GoWithoutLeash.class),
                        dogDto.getReturnedGoWithoutLeash()))
                .interactWithOtherDogs(getPropertySingle(
                        InteractWithOtherDogs.class,
                        getProperties(InteractWithOtherDogs.class),
                        dogDto.getReturnedInteractWithOtherDogs()))
                .washPaws(getPropertySingle(
                        WashPaws.class,
                        getProperties(WashPaws.class),
                        dogDto.getReturnedWashPaws()))
                .feedAfterWalk(dogDto.getFeedAfterWalk())
                .schedule(
                        getSchedule(getDate(dogDto.getWalkDate()),
                                dogDto.getWalkBegin(),
                                dogDto.getWalkingPeriod()))
                .meetingToWalker(getPropertySingle(
                        MeetingToWalker.class,
                        getProperties(MeetingToWalker.class),
                        dogDto.getReturnedMeetingToWalker()))
                .howGetKeys(getPropertySingle(
                        HowGetKeys.class,
                        getProperties(HowGetKeys.class),
                        dogDto.getReturnedHowGetKeys()))
                .additionInfo(dogDto.getAdditionInfo())
                .walkingPlace(Collections
                        .singleton(
                                getWalkingPlace(
                                        dogDto.getCity(),
                                        dogDto.getLocation(),
                                        dogDto.getAddress())))
                .build();
    }

    private LocalDate getDate(String walkDate) {
        return LocalDate.parse(walkDate);
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


    private <T extends Enum<T>> T getPropertySingle(Class<T> type, Map<String, Boolean> properties, String returnedProperty) {
        System.out.println();

        return properties.entrySet().stream()
                .filter(entry -> entry.getValue().equals(returnedProperty))
                .map(entry -> Enum.valueOf(type, entry.getKey()))
                .findFirst()
                .get();
    }

    private <T extends Enum<T>> Set<T> getPropertyList(Class<T> type, Map<String, Boolean> properties) {

        System.out.println();
        return properties.entrySet()
                .stream()
                .filter(Map.Entry::getValue)
                .map(property -> Enum.valueOf(type, property.getKey()))
                .collect(Collectors.toSet());
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