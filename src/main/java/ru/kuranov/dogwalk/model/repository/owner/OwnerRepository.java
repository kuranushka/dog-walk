package ru.kuranov.dogwalk.model.repository.owner;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kuranov.dogwalk.model.entity.owner.Owner;
import ru.kuranov.dogwalk.model.entity.security.AccountUser;
import ru.kuranov.dogwalk.model.service.interfaces.AccountUserService;

import java.util.Optional;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long>, AccountUserService {

    Optional<Owner> findByName(String ownerName);

    @Query(value = "SELECT CASE WHEN EXISTS (SELECT * FROM owner WHERE login = ?1) THEN CAST(1 AS BIT) ELSE CAST(0 AS BIT) END", nativeQuery = true)
    boolean isThereSuchLogin(String login);

    @Override
    Optional<? extends AccountUser> findByUsername(String username);
}
