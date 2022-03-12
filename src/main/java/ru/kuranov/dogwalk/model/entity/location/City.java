package ru.kuranov.dogwalk.model.entity.location;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToOne(targetEntity = WalkingPlace.class,
            mappedBy = "city")
    private WalkingPlace walkingPlace;
}
