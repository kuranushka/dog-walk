package ru.kuranov.dogwalk.model.repository.security;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import ru.kuranov.dogwalk.model.mapper.implement.UsernameRowMapper;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AccountUserRepository implements AccountUserService {

    private final JdbcTemplate jdbcTemplate;
    private final UsernameRowMapper usernameRowMapper;


    //    TODO обработать ошибку, если не находит Username
    public Optional<User> findByUsername(String username) {
        String query = "SELECT * FROM (SELECT * FROM\n" +
                "(SELECT o.id, o.username, o.password, ro.role_id as role FROM owner as o JOIN owner_role as ro ON o.id = ro.owner_id) as so\n" +
                "UNION\n" +
                "(SELECT w.id, w.username, w.password, rw.role_id as role FROM walker as w JOIN walker_role as rw ON w.id = rw.walker_id)) as foo WHERE username=?";
        return Optional.ofNullable(jdbcTemplate.queryForObject(query, usernameRowMapper, username));
    }


    public boolean isThereSuchUsername(String username) {
        String query = "SELECT * FROM (SELECT username FROM owner " +
                "UNION SELECT username FROM walker) as a " +
                "WHERE a.username = ?";
        List<String> result = jdbcTemplate.queryForList(query, String.class, username);
        return result.size() != 0;
    }
}
