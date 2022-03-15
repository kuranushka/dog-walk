package ru.kuranov.dogwalk.model.entity.addition;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public enum PullingLeash {
    HARD("Сильно тянет за поводок"),
    SOMETIMES("Иногда тянет за поводок"),
    NOT("Не тянет за поводок");

    private String name;

    public String getName() {
        return name;
    }
}
