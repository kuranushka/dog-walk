package ru.kuranov.dogwalk.model.repository.walker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kuranov.dogwalk.model.entity.walker.Walker;

import java.util.Optional;

@Repository
public interface WalkerRepository extends JpaRepository<Walker, Long> {

    Optional<Walker> findByName(String walkerName);

    @Query(value = "SELECT CASE WHEN EXISTS (SELECT * FROM walker WHERE login = ?1) THEN CAST(1 AS BIT) ELSE CAST(0 AS BIT) END", nativeQuery = true)
    boolean isThereSuchLogin(String login);
}
