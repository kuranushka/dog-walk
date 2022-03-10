package ru.kuranov.dogwalk.model.repository.behavior;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kuranov.dogwalk.model.entity.behavior.PullingLeash;

@Repository
public interface PullingLeashRepository extends JpaRepository<PullingLeash, Long> {
}
