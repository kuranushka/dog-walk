package ru.kuranov.dogwalk.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static ru.kuranov.dogwalk.exceptions.ErrorMessages.NO_SUCH_WALKER_EXCEPTION;

@AllArgsConstructor
public class NoSuchWalkerException extends RuntimeException {

    private String walkerName;

    @Getter
    private final String message = NO_SUCH_WALKER_EXCEPTION.toString() + walkerName;
}
