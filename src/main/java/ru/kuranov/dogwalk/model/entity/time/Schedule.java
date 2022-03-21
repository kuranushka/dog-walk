package ru.kuranov.dogwalk.model.entity.time;

import lombok.*;
import ru.kuranov.dogwalk.model.entity.main.Walking;
import ru.kuranov.dogwalk.model.entity.main.Dog;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "uuid")
    private String uuid;

    @OneToOne(targetEntity = Dog.class)
    @JoinColumn(name = "dog_id", nullable = true)
    private Dog dog;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "schedule")
    private Set<Walking> walking;
}
