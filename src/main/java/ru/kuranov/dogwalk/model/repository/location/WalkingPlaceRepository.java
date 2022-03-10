package ru.kuranov.dogwalk.model.repository.location;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kuranov.dogwalk.model.entity.location.WalkingPlace;

@Repository
public interface WalkingPlaceRepository extends JpaRepository<WalkingPlace, Long> {
}
