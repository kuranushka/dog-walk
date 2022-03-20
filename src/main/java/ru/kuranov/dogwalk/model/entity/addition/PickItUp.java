package ru.kuranov.dogwalk.model.entity.addition;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum PickItUp {
    YES_PICK_IT_UP("ЕСЛИ ПОДОБРАЛ С ЗЕМЛИ, ОТОБРАТЬ", false),
    TRY_TO_PICK_IT_UP("ПОПЫТАТЬСЯ ОТОБРАТЬ, ТО ЧТО ПОДОБРАЛ С ЗЕМЛИ", false),
    NO_PICK_IT_UP("ЛУЧШЕ НЕ ПЫТАТЬСЯ ОТОБРАТЬ", false);

    private String name;
    private boolean status;

    public String getName() {
        return name;
    }

    public boolean getStatus() {
        return status;
    }
}
