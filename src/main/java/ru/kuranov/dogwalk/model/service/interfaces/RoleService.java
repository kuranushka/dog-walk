package ru.kuranov.dogwalk.model.service.interfaces;

import org.springframework.stereotype.Service;
import ru.kuranov.dogwalk.model.entity.security.Role;

@Service
public interface RoleService {

    Role findByRole(String role);
}
