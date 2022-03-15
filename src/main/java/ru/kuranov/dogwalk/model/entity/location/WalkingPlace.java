package ru.kuranov.dogwalk.model.entity.location;

import lombok.*;
import ru.kuranov.dogwalk.model.entity.main.Dog;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "location")
    private String location;

    @Column(name = "address")
    private String address;
}
