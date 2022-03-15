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

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

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

    @NotNull
    private Gender gender;

    @Min(value = 1, message = "ВЕС ПИТОМЦА НЕ ДОЛЖЕН БЫТЬ МЕНЬШЕ 1 КГ")
    private int weight;

    private Set<DogDocument> dogDocuments;

    private String vet;

    private String injury;

    private PullingLeash pullingLeash;

    private PickUpFromGround pickUpFromGround;

    private PickItUp pickItUp;

    private String fear;

    private Set<Aggression> aggression;

    private boolean isGoWithoutLeash;

    private boolean isInteractWithOtherDogs;

    private WashPaws washPaws;

    private boolean isFeedAfterWalk;

    private String feed;

    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate walkDate;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime walkBegin;

    @Min(value = 20, message = "ДЛИТЕЛЬНОСТЬ ПРОГУЛКИ НЕ ДОЛЖНА БЫТЬ МЕНЕЕ 20 МИНУТ")
    private int walkingPeriod;

    private MeetingToWalker meetingToWalker;

    private HowGetKeys howGetKeys;

    @Length(max = 1024, message = "МАКСИМАЛЬНОЕ КОЛИЧЕСТВО ЗНАКОВ В ПОЛЕ ДОПОЛНИТЕЛЬНАЯ ИНФОРМАЦИЯ 1024 СИМВОЛА")
    private String additionInfo;

    @NotBlank(message = "УКАЖИТЕ ГОРОД")
    private String cityName;

    @NotBlank(message = "УКАЖИТЕ МЕТРО ИЛИ РАЙОН")
    private String location;

    @NotBlank(message = "УКАЖИТЕ ТОЧНЫЙ АДРЕС")
    private String address;
}
