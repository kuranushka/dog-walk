package ru.kuranov.dogwalk.repository.main;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kuranov.dogwalk.model.entity.main.Dog;
import ru.kuranov.dogwalk.model.entity.main.Owner;

import java.util.Optional;

@Repository
public interface DogRepository extends JpaRepository<Dog, Long> {

    Optional<Dog> findByUuid(String dogUuid);

}
