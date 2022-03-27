package ru.kuranov.dogwalk.repository.time;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kuranov.dogwalk.model.entity.time.Schedule;

import java.util.Optional;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    Optional<Schedule> findByUuid(String scheduleUuid);

}
