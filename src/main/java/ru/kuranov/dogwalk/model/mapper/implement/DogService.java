package ru.kuranov.dogwalk.model.mapper.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kuranov.dogwalk.model.dto.dog.DogDto;
import ru.kuranov.dogwalk.model.entity.addition.WeightGroup;
import ru.kuranov.dogwalk.model.entity.location.City;
import ru.kuranov.dogwalk.model.entity.main.Dog;
import ru.kuranov.dogwalk.model.entity.main.Owner;
import ru.kuranov.dogwalk.model.entity.main.Walking;
import ru.kuranov.dogwalk.model.entity.time.Schedule;
import ru.kuranov.dogwalk.model.repository.main.DogRepository;
import ru.kuranov.dogwalk.model.repository.main.WalkingRepository;
import ru.kuranov.dogwalk.model.repository.time.ScheduleRepository;
import ru.kuranov.dogwalk.model.service.interfaces.CityService;
import ru.kuranov.dogwalk.model.service.interfaces.OwnerService;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.*;

@Service
@RequiredArgsConstructor
@PropertySource("classpath:app-values.properties")
public class DogService {

    private final OwnerService ownerService;
    private final CityService cityService;
    private final DogRepository dogRepository;
    private final WalkingRepository walkingRepository;
    private final ScheduleRepository scheduleRepository;
    @Value("${dog.weight.light.max}")
    private int lightWeight;
    @Value("${dog.weight.middle.max}")
    private int middleWeight;


    public DogDto getDogDto() {
        return DogDto.builder()
                .cities(getCities())
                .build();
    }

    public List<City> getCities() {
        return cityService.findAll();
    }

    public boolean validDate(String walkDate) {
        if (walkDate.isEmpty()) {
            return false;
        }
        LocalDate date = LocalDate.parse(walkDate);
        return date.isAfter(ChronoLocalDate.from(LocalDate.now()));
    }

//    @Transactional
    public void saveNewDog(DogDto dogDto, String ownerName) {
        Dog dog = getDog(dogDto, ownerName);
        String dogUuid = UUID.randomUUID().toString();
        dog.setUuid(dogUuid);
        saveDog(dog);

        Dog savedDog = findDogIdByUuid(dogUuid);

        Walking walking = getWalking(dogDto, savedDog);
        String walkingUuid = UUID.randomUUID().toString();
        walking.setUuid(walkingUuid);
        saveWalking(walking);

        Walking savedWalking = findWalkingByUuid(walkingUuid);


        Schedule schedule = getSchedule(savedWalking, savedDog);
        String scheduleUuid = UUID.randomUUID().toString();
        schedule.setUuid(scheduleUuid);
        saveSchedule(schedule);

        Schedule savedSchedule = findScheduleByUuid(scheduleUuid);

        savedWalking.setSchedule(savedSchedule);
        saveWalking(savedWalking);

        savedDog.setSchedule(savedSchedule);
        saveDog(savedDog);
    }

    private Schedule findScheduleByUuid(String scheduleUuid) {
        //TODO сделать исключение
        Optional<Schedule> schedule = scheduleRepository.findByUuid(scheduleUuid);
        return schedule.get();
    }

    private Walking findWalkingByUuid(String walkingUuid) {
        //TODO сделать исключение
        Optional<Walking> walking = walkingRepository.findByUuid(walkingUuid);
        return walking.get();
    }

    private Dog findDogIdByUuid(String dogUuid) {
        //TODO сделать исключение
        return dogRepository.findByUuid(dogUuid).get();
    }


    public Dog getDog(DogDto dogDto, String ownerName) {
        return Dog.builder()
                .id(dogDto.getId())
                .name(dogDto.getName())
                .breed(dogDto.getBreed())
                .age(dogDto.getAge())
                .gender(dogDto.getGender())
                .owner(getOwner(ownerName))
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
                .additionInfo(dogDto.getAdditionInfo())
                .howGetKeys(dogDto.getHowGetKeys())
                .meetingToWalker(dogDto.getMeetingToWalker())
                .build();
    }

    private void saveDog(Dog dog) {
        dogRepository.save(dog);
    }

    private Walking getWalking(DogDto dogDto, Dog savedDog) {
        City city = cityService.findByName(dogDto.getCity());
        return Walking.builder()
                .dog(savedDog)
                .city(city)
                .location(dogDto.getLocation())
                .address(dogDto.getLocation())
                .walkingPrice(dogDto.getWalkingPrice())
                .walkingDate(LocalDate.parse(dogDto.getWalkingDate()))
                .walkingBegin(dogDto.getWalkingBegin())
                .walkingDuration(dogDto.getWalkingDuration())
                .build();
    }


    private void saveWalking(Walking walking) {
        walkingRepository.save(walking);
    }

    private Schedule getSchedule(Walking savedWalking, Dog savedDog) {
        Set<Walking> walkingSet = new HashSet<>();
        walkingSet.add(savedWalking);

        return Schedule.builder()
                .dog(savedDog)
                .walking(walkingSet)
                .build();
    }

    private void saveSchedule(Schedule schedule) {
        scheduleRepository.save(schedule);
    }

    private Owner getOwner(String ownerName) {
        return ownerService.findByUsername(ownerName);
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


}