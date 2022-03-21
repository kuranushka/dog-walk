package ru.kuranov.dogwalk.model.repository.main;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kuranov.dogwalk.model.entity.main.Walking;

import java.util.Optional;

@Repository
public interface WalkingRepository extends JpaRepository<Walking, Long> {
    Optional<Walking> findByUuid(String walkingUuid);

}
