package ru.kuranov.dogwalk.model.entity.addition;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum WashPaws {
    BATHROOM("В ванной"),
    SHOWER("В душе"),
    LAPOMOYKA("В лапомойке"),
    BUCKET("В ведре"),
    SINK("В раковине"),
    WIPE_WITH_CLOTH("Протереть трякочкой"),
    WIPE_WITH_NAPKINS("Протереть салфетками");

    private String name;

    public String getName() {
        return name;
    }
}
