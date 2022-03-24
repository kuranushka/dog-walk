package ru.kuranov.dogwalk.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static ru.kuranov.dogwalk.exceptions.ErrorMessages.NO_SUCH_DOG_EXCEPTION;

@AllArgsConstructor
public class NoSuchDogException extends RuntimeException{

    private String uuid;

    @Getter
    private final String message = NO_SUCH_DOG_EXCEPTION.toString() + uuid;
}
