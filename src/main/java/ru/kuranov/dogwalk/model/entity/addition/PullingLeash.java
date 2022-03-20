package ru.kuranov.dogwalk.model.entity.addition;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public enum PullingLeash {
    HARD_PULLING("СИЛЬНО ТЯНЕТ ЗА ПОВОДОК", false),
    SOMETIMES_PULLING("ИНОГДА ТЯНЕТ ЗА ПОВОДОК", false),
    NOT_PULLING("НЕ ТЯНЕТ ЗА ПОВОДОК", false);

    private String name;
    private boolean status;

    public String getName() {
        return name;
    }

    public boolean getStatus() {
        return status;
    }
}
