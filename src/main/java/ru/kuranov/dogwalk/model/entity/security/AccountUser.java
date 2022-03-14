package ru.kuranov.dogwalk.model.entity.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
