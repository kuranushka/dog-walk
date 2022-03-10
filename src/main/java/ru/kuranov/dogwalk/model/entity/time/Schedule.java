package ru.kuranov.dogwalk.model.entity.time;

import lombok.*;
import ru.kuranov.dogwalk.model.entity.dog.Dog;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToOne(targetEntity = Dog.class)
    @JoinColumn(name = "dog_id")
    private Dog dog;

    @OneToMany(targetEntity = WalkTime.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "schedule")
    private Set<WalkTime> walkTimeList;
}
