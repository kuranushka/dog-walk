package ru.kuranov.dogwalk.model.entity.addition;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum InteractWithOtherDogs {
    YES_INTERACT("МОЖНО КОНТАКТИРОВАТЬ", false),
    ONLY_IN_SPECIAL_PLACE("ТОЛЬКО НА СОБАЧЬИХ ПЛОЩАДКАХ", false),
    NOT_INTERACT("НЕЛЬЗЯ КОНТАКТИРОВАТЬ", false);

    private String name;
    private boolean status;

    public String getName() {
        return name;
    }

    public boolean getStatus() {
        return status;
    }
}
