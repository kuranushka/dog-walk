package ru.kuranov.dogwalk.model.repository.walker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kuranov.dogwalk.model.entity.walker.Walker;

@Repository
public interface WalkerRepository extends JpaRepository<Walker, Long> {
}
