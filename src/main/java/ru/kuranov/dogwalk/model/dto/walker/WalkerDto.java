package ru.kuranov.dogwalk.model.dto.walker;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import ru.kuranov.dogwalk.model.entity.location.Citizenship;
import ru.kuranov.dogwalk.model.entity.location.City;
import ru.kuranov.dogwalk.model.service.interfaces.CitizenshipService;
import ru.kuranov.dogwalk.model.service.interfaces.CityService;

import javax.annotation.PostConstruct;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Component
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WalkerDto {

    private Long id;

    @NotBlank(message = "ПОЛЕ ЛОГИН ДОЛЖНО БЫТЬ ЗАПОЛНЕНО")
    @Length(min = 6, message = "ЛОГИН МИНИМУМ 6 СИМВОЛОВ")
    private String login;

    @NotBlank(message = "ПОЛЕ ПАРОЛЬ ДОЛЖНО БЫТЬ ЗАПОЛНЕНО")
    @Length(min = 6, message = "ПАРОЛЬ МИНИМУМ 6 СИМВОЛОВ")
    private String password;

    @NotBlank(message = "ПОЛЕ ИМЯ НЕ ЗАПОЛНЕНО")
    private String name;

    @NotBlank(message = "ПОЛЕ ФАМИЛИЯ НЕ ЗАПОЛНЕНО")
    private String surname;

    @NotBlank(message = "УКАЖИТЕ ПОЧТОВЫЙ ЯЩИК")
    @Email(message = "УКАЖИТЕ ПОЧТОВЫЙ ЯЩИК, ПРИМЕР person@yandex.ru")
    private String mail;

    @Pattern(regexp = ".*7.*[0-9]{3}.*[0-9]{3}.*[0-9]{2}.*[0-9]{2}", message = "УКАЖИТЕ НОМЕР ТЕЛЕФОНА, НАПРИМЕР +7 950 250 50 50")
    private String phone;

    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate birthday;

    @NotBlank(message = "УКАЖИТЕ ГОРОД")
    private String city;

    @NotBlank(message = "УКАЖИТЕ ГРАЖДАНСТВО")
    private String citizenship;

    private List<City> cities;

    private List<Citizenship> citizenships;

    private Set<String> socialLinks;
}
