package ru.kuranov.dogwalk.model.service.interfaces;

import org.springframework.stereotype.Service;
import ru.kuranov.dogwalk.model.entity.security.Role;

import java.util.Optional;

@Service
public interface RoleService {

    Role findByRole(String role);

    Optional<Role> findById(Long id);
}
