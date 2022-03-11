package ru.kuranov.dogwalk.model.dto.owner;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Component
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OwnerDto {

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
}
