package ru.kuranov.dogwalk.model.entity.addition;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum WashPaws {
    BATHROOM("В ВАННОЙ", false),
    SHOWER("В ДУШЕ", false),
    LAPOMOYKA("В ЛАПОМОЙКЕ", false),
    BUCKET("В ВЕДРЕ", false),
    SINK("В РАКОВИНЕ", false),
    WIPE_WITH_CLOTH("ПРОТЕРЕТЬ ТРЯКОЧКОЙ", false),
    WIPE_WITH_NAPKINS("ПРОТЕРЕТЬ САЛФЕТКАМИ", false);

    private String name;
    private boolean status;

    public String getName() {
        return name;
    }

    public boolean getStatus() {
        return status;
    }
}
