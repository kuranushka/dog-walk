package ru.kuranov.dogwalk.model.repository.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kuranov.dogwalk.model.entity.security.AccountUser;
import ru.kuranov.dogwalk.model.entity.walker.Walker;

import java.util.Optional;

@Repository
public interface AccountUserRepository extends JpaRepository<Walker, Long> {

    @Query(value = "SELECT CASE WHEN EXISTS (SELECT * FROM (SELECT username FROM walker UNION SELECT username FROM owner) as a WHERE username=?1) THEN CAST(1 AS BIT) ELSE CAST(0 AS BIT) END", nativeQuery = true)
    boolean isThereSuchUsername(String username);

//    @Query(value = "SELECT a.username, a.password FROM (SELECT username, password FROM owner UNION SELECT username, password FROM walker) as a WHERE a.username = ?1", nativeQuery = true)
//    Optional<? extends AccountUser> findByUsername(String username);

    Optional<? extends AccountUser> findByUsername(String username);
}
