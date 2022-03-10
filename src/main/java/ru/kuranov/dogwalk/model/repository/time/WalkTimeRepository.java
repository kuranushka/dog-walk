package ru.kuranov.dogwalk.model.repository.time;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kuranov.dogwalk.model.entity.time.WalkTime;

@Repository
public interface WalkTimeRepository extends JpaRepository<WalkTime, Long> {
}
