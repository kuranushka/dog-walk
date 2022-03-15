package ru.kuranov.dogwalk.model.repository.security;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import ru.kuranov.dogwalk.model.repository.UsernameMapper;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AccountUserRepository implements AccountUserService {

    private final JdbcTemplate jdbcTemplate;
    private final UsernameMapper usernameMapper;

    public Optional<User> findByUsername(String username) {
        String query = "SELECT a.id, a.username, a.password, r.role_id as role " +
                "FROM (SELECT id, username, password FROM owner UNION SELECT id, username, password FROM walker) as a " +
                "         JOIN (SELECT owner_id as id, role_id FROM owner_role " +
                "UNION SELECT walker_id, role_id FROM walker_role) as r ON a.id=r.id " +
                "WHERE a.username = ?";
        return Optional.ofNullable(jdbcTemplate.queryForObject(query, usernameMapper, username));
    }

    public boolean isThereSuchUsername(String username) {
        String query = "SELECT * FROM (SELECT username FROM owner UNION SELECT username FROM walker) as a WHERE username = ?";
        List<String> result = jdbcTemplate.queryForList(query, String.class, username);
        if (result.size() == 0) {
            return false;
        } else {
            return true;
        }
    }
}
