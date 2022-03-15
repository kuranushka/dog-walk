package ru.kuranov.dogwalk.model.entity.addition;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum HowGetKeys {
    HOME_WILL_MEET("Дома встретят"),
    KEYS_WILL_BE_IN_A_SECRET_PLACE("Ключи в тайном месте"),
    HAND_OVER_TO_WALKER("Передам лично"),
    OTHER("Другое");

    private String name;

    public String getName() {
        return name;
    }
}
