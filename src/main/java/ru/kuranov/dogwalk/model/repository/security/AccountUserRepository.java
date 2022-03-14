package ru.kuranov.dogwalk.model.repository.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kuranov.dogwalk.model.entity.walker.Walker;

@Repository
public interface AccountUserRepository extends JpaRepository<Walker, Long> {

    @Query(value = "SELECT CASE WHEN EXISTS (SELECT * FROM (SELECT username FROM walker UNION SELECT username FROM owner) as a WHERE username=?1) THEN CAST(1 AS BIT) ELSE CAST(0 AS BIT) END", nativeQuery = true)
    boolean isThereSuchUsername(String username);
}
