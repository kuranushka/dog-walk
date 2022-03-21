package ru.kuranov.dogwalk.model.dto.dog;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;
import ru.kuranov.dogwalk.model.entity.addition.*;
import ru.kuranov.dogwalk.model.entity.location.City;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Component
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DogDto {

    public Set<DogDocument> dogDocuments;
    private Long id;
    @NotBlank(message = "ПОЛЕ КЛИЧКА НЕ ЗАПОЛНЕНО")
    private String name;
    private String breed;
    private String age;
    private Gender gender;
    private int weight;
    private String vet;

    private String injury;

    private PullingLeash pullingLeash;

    private PickUpFromGround pickUpFromGround;

    private PickItUp pickItUp;

    private String fear;

    private Set<Aggression> aggression;

    private GoWithoutLeash goWithoutLeash;

    private InteractWithOtherDogs interactWithOtherDogs;

    private WashPaws washPaws;

    private String feedAfterWalk;

    private String walkingDate;

    private LocalTime walkingBegin;

    @Min(value = 20, message = "ДЛИТЕЛЬНОСТЬ ПРОГУЛКИ НЕ ДОЛЖНА БЫТЬ МЕНЕЕ 20 МИНУТ")
    private int walkingDuration;

    private MeetingToWalker meetingToWalker;

    private HowGetKeys howGetKeys;

    @Length(max = 1024, message = "МАКСИМАЛЬНОЕ КОЛИЧЕСТВО ЗНАКОВ В ПОЛЕ ДОПОЛНИТЕЛЬНАЯ ИНФОРМАЦИЯ 1024 СИМВОЛА")
    private String additionInfo;

    @NotBlank(message = "УКАЖИТЕ ГОРОД")
    private String city;

    private List<City> cities;

    @NotBlank(message = "УКАЖИТЕ МЕТРО ИЛИ РАЙОН")
    private String location;

    private String address;

    @Min(value = 100L, message = "МИНИМАЛЬНАЯ СТОИМОСТЬ 100 РУБЛЕЙ")
    private int walkingPrice;
}
