package ru.kuranov.dogwalk.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static ru.kuranov.dogwalk.exceptions.ErrorMessages.NO_SUCH_OWNER_EXCEPTION;

@AllArgsConstructor
public class NoSuchOwnerException extends RuntimeException {

    private String ownerName;

    @Getter
    private final String message = NO_SUCH_OWNER_EXCEPTION.toString() + ownerName;

}
