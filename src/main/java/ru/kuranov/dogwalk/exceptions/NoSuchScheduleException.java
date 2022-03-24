package ru.kuranov.dogwalk.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static ru.kuranov.dogwalk.exceptions.ErrorMessages.NO_SUCH_CITY_EXCEPTION;
import static ru.kuranov.dogwalk.exceptions.ErrorMessages.NO_SUCH_SCHEDULE_EXCEPTION;

@AllArgsConstructor
public class NoSuchScheduleException  extends RuntimeException{

    private String uuid;

    @Getter
    private final String message = NO_SUCH_SCHEDULE_EXCEPTION.toString() + uuid;
}
