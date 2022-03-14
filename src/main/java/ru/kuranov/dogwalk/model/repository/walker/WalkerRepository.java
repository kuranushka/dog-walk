package ru.kuranov.dogwalk.model.repository.walker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kuranov.dogwalk.model.entity.security.AccountUser;
import ru.kuranov.dogwalk.model.entity.walker.Walker;
import ru.kuranov.dogwalk.model.service.interfaces.AccountUserService;

import java.util.Optional;

@Repository
public interface WalkerRepository extends JpaRepository<Walker, Long>, AccountUserService {

    Optional<Walker> findByName(String walkerName);

    @Query(value = "SELECT CASE WHEN EXISTS (SELECT * FROM walker WHERE username = ?1) THEN CAST(1 AS BIT) ELSE CAST(0 AS BIT) END", nativeQuery = true)
    boolean isThereSuchUsername(String username);

    @Override
    Optional<? extends AccountUser> findByUsername(String username);
}
