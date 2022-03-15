package ru.kuranov.dogwalk.model.entity.addition;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum PickUpFromGround {
    HARD("Постоянно подбирает с земли"),
    SOMETIMES("Иногда подбирает с земли"),
    NOT("Не подбирает с земли");

    private String name;

    public String getName() {
        return name;
    }
}
