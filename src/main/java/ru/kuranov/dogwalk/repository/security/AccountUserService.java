package ru.kuranov.dogwalk.repository.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface AccountUserService {

    Optional<User> findByUsername(String username);

    boolean isThereSuchUsername(String username);
}
