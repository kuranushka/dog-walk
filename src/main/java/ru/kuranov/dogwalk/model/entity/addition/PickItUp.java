package ru.kuranov.dogwalk.model.entity.addition;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum PickItUp {
    YES("Если подобрал с земли, отобрать"),
    TRY("Попытаться отобрать, то что подобрал с земли"),
    NO("Лучше не пытаться отобрать");

    private String name;

    public String getName() {
        return name;
    }
}
