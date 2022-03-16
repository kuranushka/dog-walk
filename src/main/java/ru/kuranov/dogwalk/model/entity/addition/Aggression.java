package ru.kuranov.dogwalk.model.entity.addition;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Aggression {
    DOGS("К собакам"),
    CATS("К кошкам"),
    MALES("К кобелям"),
    PEOPLE("К людям"),
    CHILDREN("К детям"),
    MOTORCYCLISTS("К мотоциклистам"),
    CYCLISTS("К велосипедистам"),
    CARS("К автомобилям");

    private String name;

    public String getName() {
        return name;
    }
}
