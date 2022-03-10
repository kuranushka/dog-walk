package ru.kuranov.dogwalk.model.repository.dog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kuranov.dogwalk.model.entity.dog.DogDocument;

@Repository
public interface DogDocumentRepository extends JpaRepository<DogDocument, Long> {
}
