package ru.kuranov.dogwalk.model.repository.main;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kuranov.dogwalk.model.entity.main.Dog;

@Repository
public interface DogRepository extends JpaRepository<Dog, Long> {
}
