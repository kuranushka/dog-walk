package ru.kuranov.dogwalk.exceptions;

import lombok.AllArgsConstructor;

@AllArgsConstructor


public enum ErrorMessages {
    NO_SUCH_OWNER_EXCEPTION("Cannot find owner with name "),
    NO_SUCH_CITY_EXCEPTION("Cannot find city with name "),
    NO_SUCH_CITIZENSHIP_EXCEPTION("Cannot find citizenship with name "),
    NO_SUCH_WALKER_EXCEPTION("Cannot find walker with name "),
    NO_SUCH_ROLE_EXCEPTION("Cannot find role with name "),
    USER_WITH_THIS_LOGIN_ALREADY_EXISTS("ПОЛЬЗОВАТЕЛЬ С ТАКИМ ЛОГИНОМ УЖЕ СУЩЕСТВУЕТ");
//    CURRENT_USER_DELETE_EXCEPTION ("Cannot delete yourself. Operation denied"),
//    NO_CURRENT_USER_EXCEPTION("Cannot get current user"),
//    NO_SUCH_ORDER_EXCEPTION("Cannot find order with id "),
//    NO_SUCH_PRODUCT_EXCEPTION("Cannot find order with id "),
//    NO_SUCH_USER_EXCEPTION("Cannot find product with id "),
//    SUPER_ADMIN_DELETE_EXCEPTION("Cannot delete user with role SUPERADMIN. Operation denied"),
//    USER_IS_BLOCKED_EXCEPTION("Account is blocked"),
//    USER_WITH_SUCH_EMAIL_EXISTS_EXCEPTION("User with such email exists"),
//    USER_WITH_SUCH_PHONE_NUMBER_EXISTS_EXCEPTION("User with such phone number exists"),
//    USER_WITH_SUCH_USERNAME_EXISTS_EXCEPTION("User with such username exists");


    private String message;


    @Override
    public String toString() {
        return message;
    }
}
