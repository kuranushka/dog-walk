package ru.kuranov.dogwalk.model.repository.location;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kuranov.dogwalk.model.entity.location.Citizenship;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface CitizenshipRepository extends JpaRepository<Citizenship, Long> {

    Optional<Citizenship> findByName(String name);

    List<Citizenship> findAll();
}
