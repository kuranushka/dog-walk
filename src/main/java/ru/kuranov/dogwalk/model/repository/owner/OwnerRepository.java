package ru.kuranov.dogwalk.model.repository.owner;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kuranov.dogwalk.model.entity.owner.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
