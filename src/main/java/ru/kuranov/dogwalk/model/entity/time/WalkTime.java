package ru.kuranov.dogwalk.model.entity.time;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "walk_time")
public class WalkTime {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "walk_date")
    private LocalDate walkDate;

    @Column(name = "walk_begin")
    private LocalTime walkBegin;

    @Column(name = "walk_end")
    private LocalTime walkEnd;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;
}
