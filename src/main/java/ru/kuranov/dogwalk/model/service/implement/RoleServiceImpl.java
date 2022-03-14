package ru.kuranov.dogwalk.model.service.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kuranov.dogwalk.exceptions.NoSuchRoleException;
import ru.kuranov.dogwalk.model.entity.security.Role;
import ru.kuranov.dogwalk.model.repository.security.RoleRepository;
import ru.kuranov.dogwalk.model.service.interfaces.RoleService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public Role findByRole(String role) {
        Optional<Role> roleOptional = roleRepository.findByRole(role);
        if (roleOptional.isPresent()) {
            return roleOptional.get();
        } else {
            throw new NoSuchRoleException(role);
        }
    }
}
