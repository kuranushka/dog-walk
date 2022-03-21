package ru.kuranov.dogwalk.model.repository.location;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kuranov.dogwalk.model.entity.main.Walking;

@Repository
public interface WalkingPlaceRepository extends JpaRepository<Walking, Long> {
}
