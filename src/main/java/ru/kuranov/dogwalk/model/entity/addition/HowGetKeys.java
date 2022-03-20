package ru.kuranov.dogwalk.model.entity.addition;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum HowGetKeys {
    HOME_WILL_MEET("ДОМА ВСТРЕТЯТ", false),
    KEYS_WILL_BE_IN_A_SECRET_PLACE("КЛЮЧИ В ТАЙНОМ МЕСТЕ", false),
    HAND_OVER_TO_WALKER("ПЕРЕДАМ ЛИЧНО", false),
    OTHER_VARIANT("ДРУГОЕ", false);

    private String name;
    private boolean status;

    public String getName() {
        return name;
    }

    public boolean getStatus() {
        return status;
    }
}
