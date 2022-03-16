package ru.kuranov.dogwalk.model.mapper.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import ru.kuranov.dogwalk.model.entity.security.Role;
import ru.kuranov.dogwalk.model.service.interfaces.RoleService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UsernameRowMapper implements RowMapper<User> {

    private final RoleService roleService;

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new User(
                rs.getString("username"),
                rs.getString("password"),
                getAuthority(rs.getLong("role")));
    }

    private Collection<GrantedAuthority> getAuthority(long id) {
        Optional<Role> role = roleService.findById(id);
        return Collections.singleton(new SimpleGrantedAuthority(role.get().getRole()));
    }
}
