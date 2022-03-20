package ru.kuranov.dogwalk.model.entity.addition;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum MeetingToWalker {

    ON_THE_FIRST_WALK("НА ПЕРВОЙ ПРОГУЛКЕ", false),
    BEFORE_THE_FIRST_WALK("ДО ПЕРВОЙ ПРОГУЛКИ", false),
    NO_MEETING_REQUIRED("ЗНАКОМСТВО НЕ ТРЕБУЕТСЯ", false);

    private String name;
    private boolean status;

    public String getName() {
        return name;
    }

    public boolean getStatus() {
        return status;
    }
}
