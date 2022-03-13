package ru.kuranov.dogwalk.model.service.interfaces;

import org.springframework.stereotype.Service;
import ru.kuranov.dogwalk.model.entity.security.AccountUser;

import java.util.Optional;

@Service
public interface AccountUserService {
    Optional<? extends AccountUser> findByUsername(String username);
}
