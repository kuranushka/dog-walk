package ru.kuranov.dogwalk.model.entity.addition;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum PickUpFromGround {
    ALWAYS_PICK_UP("ПОСТОЯННО ПОДБИРАЕТ С ЗЕМЛИ", false),
    SOMETIMES_PICK_UP("ИНОГДА ПОДБИРАЕТ С ЗЕМЛИ", false),
    NOT_PICK_UP("НЕ ПОДБИРАЕТ С ЗЕМЛИ", false);

    private String name;
    private boolean status;

    public String getName() {
        return name;
    }

    public boolean getStatus() {
        return status;
    }
}
