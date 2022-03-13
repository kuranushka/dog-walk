package ru.kuranov.dogwalk.model.entity.security;

import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AccountUser {

    private String username;

    private String password;

    private Set<Role> roles;
}
