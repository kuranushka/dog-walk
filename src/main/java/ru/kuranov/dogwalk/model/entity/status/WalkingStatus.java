package ru.kuranov.dogwalk.model.entity.status;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum WalkingStatus {
    ACTIVE("Активен", false),
    CLOSE("Закрыт", false);

    private String name;
    private boolean status;

    public String getName() {
        return name;
    }

    public boolean getStatus() {
        return status;
    }
}
