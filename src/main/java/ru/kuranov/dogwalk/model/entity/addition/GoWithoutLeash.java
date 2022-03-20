package ru.kuranov.dogwalk.model.entity.addition;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum GoWithoutLeash {
    YES_GO_WITHOUT_LEASH("МОЖНО И НУЖНО", false),
    GO_ONLY_IN_SPECIAL_PLACE("МОЖНО ТОЛЬКО НА СОБАЧЬИХ ПЛОЩАДКАХ", false),
    NOT_GO_WITHOUT_LEASH("КАТЕГОРИЧЕСКИ НЕЛЬЗЯ", false);

    private String name;
    private boolean status;

    public String getName() {
        return name;
    }

    public boolean getStatus() {
        return status;
    }
}
