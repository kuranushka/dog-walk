package ru.kuranov.dogwalk.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static ru.kuranov.dogwalk.exceptions.ErrorMessages.NO_SUCH_ROLE_EXCEPTION;

@AllArgsConstructor
public class NoSuchRoleException extends RuntimeException {

    private String role;

    @Getter
    private final String message = NO_SUCH_ROLE_EXCEPTION.toString() + role;

}
