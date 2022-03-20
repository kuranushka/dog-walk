package ru.kuranov.dogwalk.model.entity.addition;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum DogDocument {
    VETERINARY_PASSPORT("ВЕТПАСПОРТ", false),
    VACCINATIONS("СЕРТИФИКАТ О ПРИВИВКАХ", false),
    TICK_PROTECTION("ЗАЩИТА ОТ КЛЕЩЕЙ", false),
    CASTRATION_OR_STERILIZATION("КАСТРАЦИЯ ИЛИ СТЕРИЛИЗАЦИЯ", false);

    private String name;
    private boolean status;

    public String getName() {
        return name;
    }

    public boolean getStatus() {
        return status;
    }
}
