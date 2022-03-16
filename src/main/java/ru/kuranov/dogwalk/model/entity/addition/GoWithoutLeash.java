package ru.kuranov.dogwalk.model.entity.addition;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum GoWithoutLeash {
    YES("МОЖНО И НУЖНО"),
    ONLY_IN_SPECIAL_PLACE("МОЖНО ТОЛЬКО НА СОБАЧЬИХ ПЛОЩАДКАХ"),
    NO("КАТЕГОРИЧЕСКИ НЕЛЬЗЯ");

    private String name;

    public String getName() {
        return name;
    }
}
