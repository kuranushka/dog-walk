package ru.kuranov.dogwalk.model.repository.main;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kuranov.dogwalk.model.entity.main.Walker;

import java.util.Optional;

@Repository
public interface WalkerRepository extends JpaRepository<Walker, Long> {

    Optional<Walker> findByName(String walkerName);

}
