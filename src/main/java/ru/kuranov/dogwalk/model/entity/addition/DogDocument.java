package ru.kuranov.dogwalk.model.entity.addition;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum DogDocument {
    VETERINARY_PASSPORT("Ветпаспорт"),
    VACCINATIONS("Сертификат о прививках"),
    TICK_PROTECTION("Защита от клещей"),
    CASTRATION_OR_STERILIZATION("Кастрация или стерилизация"),
    NONE("Ничего");

    private String name;

    public String getName() {
        return name;
    }

}
