package ru.kuranov.dogwalk.model.dto.dog;

import lombok.*;
import org.springframework.stereotype.Component;
import ru.kuranov.dogwalk.model.entity.location.City;

import javax.validation.constraints.NotBlank;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@Component
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DogDto {

    private Long id;

    //    @NotBlank(message = "ПОЛЕ КЛИЧКА НЕ ЗАПОЛНЕНО")
    private String name;

    private String breed;

    private String age;

    private Map<String, Boolean> gender;

    private String returnedGender;

    private int weight;

    public Map<String, Boolean> dogDocuments;

    private String vet;

    private String injury;

    private Map<String, Boolean> pullingLeash;

    private String returnedPullingLeash;

    private Map<String, Boolean> pickUpFromGround;

    private String returnedPickUpFromGround;

    private Map<String, Boolean> pickItUp;

    private String returnedPickItUp;

    private String fear;

    private Map<String, Boolean> aggression;

    private Map<String, Boolean> goWithoutLeash;

    private String returnedGoWithoutLeash;

    private Map<String, Boolean> interactWithOtherDogs;

    private String returnedInteractWithOtherDogs;

    private Map<String, Boolean> washPaws;

    private String returnedWashPaws;

    private String feedAfterWalk;

    //    @DateTimeFormat(pattern = "dd.MM.yyyy")
//    @FutureOrPresent(message = "УКАЖИТЕ ДАТУ ПРОГУЛКИ, СЕГОДНЯ ЛИБО ПОЗЖЕ")
    @NotBlank(message = "НЕ ВЫБРАНА ДАТА ПРОГУЛКИ")
    private String walkDate;
    //private String walkDate;
//    @DateTimeFormat(pattern = "HH:mm")
//    @FutureOrPresent(message = "ВРЕМЯ ПРОГУЛКИ, СЕЙЧАС ЛИБО ПОЗЖЕ")
    private LocalTime walkBegin;

    //    @Min(value = 20, message = "ДЛИТЕЛЬНОСТЬ ПРОГУЛКИ НЕ ДОЛЖНА БЫТЬ МЕНЕЕ 20 МИНУТ")
    private int walkingPeriod;

    private Map<String, Boolean> meetingToWalker;

    private String returnedMeetingToWalker;

    private Map<String, Boolean> howGetKeys;

    private String returnedHowGetKeys;

    //    @Length(max = 1024, message = "МАКСИМАЛЬНОЕ КОЛИЧЕСТВО ЗНАКОВ В ПОЛЕ ДОПОЛНИТЕЛЬНАЯ ИНФОРМАЦИЯ 1024 СИМВОЛА")
    private String additionInfo;

    //    @NotBlank(message = "УКАЖИТЕ ГОРОД")
    private String city;

    private List<City> cities;

    //    @NotBlank(message = "УКАЖИТЕ МЕТРО ИЛИ РАЙОН")
    private String location;

    private String address;
}
