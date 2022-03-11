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

    @NotBlank(message = "ЛОГИН БЫТЬ НЕ МЕНЕЕ 6 СИМВОЛОВ")
    @Length(min = 6, message = "ЛОГИН БЫТЬ НЕ МЕНЕЕ 6 СИМВОЛОВ")
    private String login;

    @NotBlank(message = "ПАРОЛЬ БЫТЬ НЕ МЕНЕЕ 6 СИМВОЛОВ")
    @Length(min = 6, message = "ПАРОЛЬ БЫТЬ НЕ МЕНЕЕ 6 СИМВОЛОВ")
    private String password;

//    @NotBlank(message = "ПОЛЕ ТЕЛЕФОН ВЕТЕРИНАРНОЙ КЛИНИКИ НЕ ЗАПОЛНЕНО")
    private String name;

//    @NotBlank(message = "ПОЛЕ ТЕЛЕФОН ВЕТЕРИНАРНОЙ КЛИНИКИ НЕ ЗАПОЛНЕНО")
    private String surname;

//    @Email(message = "УКАЖИТЕ ПОЧТОВЫЙ ЯЩИК, ПРИМЕР person@yandex.ru")
    private String mail;

//    @Pattern(regexp = "\\+7\\s[0-9]{3}\\s[0-9]{3}\\s[0-9]{2}\\s[0-9]{2}", message = "УКАЖИТЕ НОМЕР ТЕЛЕФОНА, ПРИМЕР +7 950 250 50 50")
    private String phone;
}
