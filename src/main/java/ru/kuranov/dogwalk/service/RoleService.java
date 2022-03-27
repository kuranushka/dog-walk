package ru.kuranov.dogwalk.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kuranov.dogwalk.exceptions.NoSuchRoleException;
import ru.kuranov.dogwalk.model.entity.security.Role;
import ru.kuranov.dogwalk.repository.security.RoleRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Role findByRole(String role) {
        Optional<Role> roleOptional = roleRepository.findByRole(role);
        if (roleOptional.isPresent()) {
            return roleOptional.get();
        } else {
            throw new NoSuchRoleException(role);
        }
    }

    public Optional<Role> findById(Long id) {
        return roleRepository.findById(id);
    }
}
