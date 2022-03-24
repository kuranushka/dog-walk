package ru.kuranov.dogwalk.model.entity.main;

import lombok.*;
import ru.kuranov.dogwalk.model.entity.location.City;
import ru.kuranov.dogwalk.model.entity.status.WalkingStatus;
import ru.kuranov.dogwalk.model.entity.time.Schedule;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "walking")
public class Walking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "uuid")
    private String uuid;

    @ManyToOne
    @JoinColumn(name = "dog_id")
    private Dog dog;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    @OneToOne(targetEntity = City.class,
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id")
    private City city;

    @Column(name = "location")
    private String location;

    @Column(name = "address")
    private String address;

    @Column(name = "walking_price")
    private int walkingPrice;

    @Column(name = "walking_date")
    private LocalDate walkingDate;

    @Column(name = "walking_begin")
    private LocalTime walkingBegin;

    @Column(name = "walking_duration")
    private int walkingDuration;

    @Column(name = "walking_status")
    @Enumerated(EnumType.STRING)
    private WalkingStatus walkingStatus;

    @ManyToOne
    @JoinColumn(name = "walker_id")
    private Walker walker;
}
