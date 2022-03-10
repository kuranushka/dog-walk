package ru.kuranov.dogwalk.model.entity.location;

import lombok.*;
import ru.kuranov.dogwalk.model.entity.dog.Dog;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "walking_place")
public class WalkingPlace {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "dog_id")
    private Dog dog;

    @OneToOne(targetEntity = City.class,
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            optional = false)
    @JoinColumn(name = "city_id")
    private City city;

    @OneToOne(targetEntity = Metro.class,
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            optional = false)
    @JoinColumn(name = "metro_id")
    private Metro metro;

    @OneToOne(targetEntity = District.class,
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            optional = false)
    @JoinColumn(name = "district_id")
    private District district;
}
