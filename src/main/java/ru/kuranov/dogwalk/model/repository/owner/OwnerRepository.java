package ru.kuranov.dogwalk.model.repository.owner;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kuranov.dogwalk.model.entity.owner.Owner;

import java.util.Optional;

@Repository
@Primary
public interface OwnerRepository extends JpaRepository<Owner, Long> {

    Optional<Owner> findByName(String ownerName);
}
