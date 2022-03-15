package ru.kuranov.dogwalk.model.dto.walker;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;
import ru.kuranov.dogwalk.model.entity.location.City;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
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
    private String username;

    @NotBlank(message = "ПОЛЕ ПАРОЛЬ ДОЛЖНО БЫТЬ ЗАПОЛНЕНО")
    @Length(min = 6, message = "ПАРОЛЬ МИНИМУМ 6 СИМВОЛОВ")
    private String password;

    private String name;

    private String surname;

    @NotBlank(message = "УКАЖИТЕ ПОЧТОВЫЙ ЯЩИК")
    @Email(message = "УКАЖИТЕ ПОЧТОВЫЙ ЯЩИК, ПРИМЕР person@yandex.ru")
    private String mail;

    @NotBlank(message = "УКАЖИТЕ НОМЕР ТЕЛЕФОНА")
    private String phone;

    private LocalDate birthday;

    @NotBlank(message = "УКАЖИТЕ ГОРОД")
    private String city;

    private String citizenship;

    private List<City> cities;

    private Set<String> socialLinks;
}
