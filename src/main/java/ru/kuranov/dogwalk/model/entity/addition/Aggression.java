package ru.kuranov.dogwalk.model.entity.addition;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Aggression {
    TO_DOGS("К СОБАКАМ", false),
    TO_CATS("К КОШКАМ", false),
    TO_MALES("К КОБЕЛЯМ", false),
    TO_PEOPLE("К ЛЮДЯМ", false),
    TO_CHILDREN("К ДЕТЯМ", false),
    TO_MOTORCYCLISTS("К МОТОЦИКЛИСТАМ", false),
    TO_CYCLISTS("К ВЕЛОСИПЕДИСТАМ", false),
    TO_CARS("К АВТОМОБИЛЯМ", false);

    private String name;
    private boolean status;

    public String getName() {
        return name;
    }

    public boolean getStatus() {
        return status;
    }
}
