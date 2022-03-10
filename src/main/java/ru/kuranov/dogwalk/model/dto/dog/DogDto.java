package ru.kuranov.dogwalk.model.dto.dog;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import ru.kuranov.dogwalk.model.entity.addition.HowGetPet;
import ru.kuranov.dogwalk.model.entity.addition.MeetingToWalker;
import ru.kuranov.dogwalk.model.entity.addition.WashPaws;
import ru.kuranov.dogwalk.model.entity.behavior.Aggression;
import ru.kuranov.dogwalk.model.entity.behavior.PickItUp;
import ru.kuranov.dogwalk.model.entity.behavior.PickUpFromGround;
import ru.kuranov.dogwalk.model.entity.behavior.PullingLeash;
import ru.kuranov.dogwalk.model.entity.dog.DogDocument;
import ru.kuranov.dogwalk.model.entity.dog.Gender;
import ru.kuranov.dogwalk.model.entity.dog.Vet;
import ru.kuranov.dogwalk.model.entity.dog.WeightGroup;
import ru.kuranov.dogwalk.model.entity.location.City;
import ru.kuranov.dogwalk.model.entity.location.WalkingPlace;
import ru.kuranov.dogwalk.model.entity.time.Schedule;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
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

    private String ownerName;

    @NotBlank(message = "ПОЛЕ КЛИЧКА НЕ ЗАПОЛНЕНО")
    private String name;

    @NotBlank(message = "ПОЛЕ ПОРОДА НЕ ЗАПОЛНЕНО")
    private String breed;

    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate birthday;

    private Gender gender;

    @NonNull()
    @Min(value = 1, message = "ВЕС ПИТОМЦА НЕ ДОЛЖЕН БЫТЬ МЕНЬШЕ 1 КГ")
    private int weight;

    private Set<DogDocument> dogDocuments;

    @NotBlank(message = "ПОЛЕ АДРЕС ВЕТЕРИНАРНОЙ КЛИНИКИ НЕ ЗАПОЛНЕНО")
    private String vetAddress;

    @NotBlank(message = "ПОЛЕ ТЕЛЕФОН ВЕТЕРИНАРНОЙ КЛИНИКИ НЕ ЗАПОЛНЕНО")
    private String vetPhone;

    private String injury;

    private Set<PullingLeash> pullingLeash;

    private Set<PickUpFromGround> pickUpFromGround;

    private Set<PickItUp> pickItUp;

    private String fear;

    private Set<Aggression> aggression;

    private boolean isGoWithoutLeash;

    private boolean isInteractWithOtherDogs;

    private boolean isWashPaws;

    private Set<WashPaws> washPaws;

    private boolean isFeedAfterWalk;

    private String feed;

    private String portion;

    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate walkDate;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime walkBegin;

    @NonNull()
    @Min(value = 15, message = "ДЛИТЕЛЬНОСТЬ ПРОГУЛКИ НЕ ДОЛЖНА БЫТЬ МЕНЕЕ 15 МИНУТ")
    private int walkingPeriod;

    private Set<MeetingToWalker> meetingToWalker;

    private Set<HowGetPet> howGetPet;

    @Length(max = 1024, message = "МАКСИМАЛЬНОЕ КОЛИЧЕСТВО ЗНАКОВ В ПОЛЕ ДОПОЛНИТЕЛЬНАЯ ИНФОРМАЦИЯ 1024 СИМВОЛА")
    private String additionInfo;

    @NotBlank(message = "УКАЖИТЕ ГОРОД")
    private String cityName;

    private boolean isMetro;

    @NotBlank(message = "УКАЖИТЕ МЕСТО")
    private String location;
}
