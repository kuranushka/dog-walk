package ru.kuranov.dogwalk.model.entity.addition;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum MeetingToWalker {

    ON_THE_FIRST_WALK("На первой прогулке"),
    BEFORE_THE_FIRST_WALK("До первой прогулки"),
    NO_MEETING_REQUIRED("Знакомство не требуется");

    private String name;

    public String getName() {
        return name;
    }
}
