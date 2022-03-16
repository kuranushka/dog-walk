package ru.kuranov.dogwalk.model.entity.addition;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum InteractWithOtherDogs {
    YES("МОЖНО"),
    ONLY_IN_SPECIAL_PLACE("ТОЛЬКО НА СОБАЧЬИХ ПЛОЩАДКАХ"),
    NO("НЕЛЬЗЯ");

    private String name;

    public String getName() {
        return name;
    }
}
