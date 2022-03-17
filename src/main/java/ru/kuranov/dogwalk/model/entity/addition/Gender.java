package ru.kuranov.dogwalk.model.entity.addition;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Gender {
    MALE("САМЕЦ"),
    FEMALE("САМОЧКА");

    private String name;

    public String getName() {
        return name;
    }
}
