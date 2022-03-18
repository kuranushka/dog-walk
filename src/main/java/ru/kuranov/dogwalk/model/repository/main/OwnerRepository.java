package ru.kuranov.dogwalk.model.repository.main;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kuranov.dogwalk.model.entity.main.Owner;

import java.util.Optional;

@Repository
@Primary
public interface OwnerRepository extends JpaRepository<Owner, Long> {

    Optional<Owner> findByUsername(String ownerName);
}
