package ru.kuranov.dogwalk.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static ru.kuranov.dogwalk.exceptions.ErrorMessages.NO_SUCH_CITIZENSHIP_EXCEPTION;

@AllArgsConstructor
public class NoSuchCitizenshipException extends RuntimeException {

    private String name;

    @Getter
    private final String message = NO_SUCH_CITIZENSHIP_EXCEPTION.toString() + name;
}
