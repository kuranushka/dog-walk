package ru.kuranov.dogwalk.model.repository.addition;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kuranov.dogwalk.model.entity.addition.MeetingToWalker;

@Repository
public interface MeetingToWalkerRepository extends JpaRepository<MeetingToWalker, Long> {
}
