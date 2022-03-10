package ru.kuranov.dogwalk.model.repository.time;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kuranov.dogwalk.model.entity.time.Schedule;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
