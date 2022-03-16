package ru.kuranov.dogwalk.model.dto.dog;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import ru.kuranov.dogwalk.model.entity.addition.HowGetKeys;
import ru.kuranov.dogwalk.model.entity.addition.MeetingToWalker;
import ru.kuranov.dogwalk.model.entity.addition.WashPaws;
import ru.kuranov.dogwalk.model.entity.addition.Aggression;
import ru.kuranov.dogwalk.model.entity.addition.PickItUp;
import ru.kuranov.dogwalk.model.entity.addition.PickUpFromGround;
import ru.kuranov.dogwalk.model.entity.addition.PullingLeash;
import ru.kuranov.dogwalk.model.entity.addition.DogDocument;
import ru.kuranov.dogwalk.model.entity.addition.Gender;
import ru.kuranov.dogwalk.model.entity.location.City;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Component
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DogDto {

    private Long id;

    @NotBlank(message = "ПОЛЕ КЛИЧКА НЕ ЗАПОЛНЕНО")
    private String name;

    private String breed;

    private String age;

    private Gender gender;

    private int weight;

    private List<DogDocument> dogDocuments;

    private String vet;

    private String injury;

    private List<PullingLeash> pullingLeash;

    private List<PickUpFromGround> pickUpFromGround;

    private List<PickItUp> pickItUp;

    private String fear;

    private List<Aggression> aggression;

    private boolean isGoWithoutLeash;

    private boolean isInteractWithOtherDogs;

    private List<WashPaws> washPaws;

    private String feedAfterWalk;

    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @FutureOrPresent(message = "УКАЖИТЕ ДАТУ ПРОГУЛКИ, СЕГОДНЯ ЛИБО ПОЗЖЕ")
    private LocalDate walkDate;

    @DateTimeFormat(pattern = "HH:mm")
    @FutureOrPresent(message = "ВРЕМЯ ПРОГУЛКИ, СЕЙЧАС ЛИБО ПОЗЖЕ")
    private LocalTime walkBegin;

    @Min(value = 20, message = "ДЛИТЕЛЬНОСТЬ ПРОГУЛКИ НЕ ДОЛЖНА БЫТЬ МЕНЕЕ 20 МИНУТ")
    private int walkingPeriod;

    private List<MeetingToWalker> meetingToWalker;

    private List<HowGetKeys> howGetKeys;

    @Length(max = 1024, message = "МАКСИМАЛЬНОЕ КОЛИЧЕСТВО ЗНАКОВ В ПОЛЕ ДОПОЛНИТЕЛЬНАЯ ИНФОРМАЦИЯ 1024 СИМВОЛА")
    private String additionInfo;

    @NotBlank(message = "УКАЖИТЕ ГОРОД")
    private String city;

    private List<City> cities;

    @NotBlank(message = "УКАЖИТЕ МЕТРО ИЛИ РАЙОН")
    private String location;

    private String address;
}
